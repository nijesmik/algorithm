const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];

rl.on('line', (line) => {
  input.push(line);
}).on('close', () => {
  const answer = solution(input);
  console.log(answer);
  process.exit(0);
});

const DIRECTION = {
  1: [0, -1],
  2: [-1, -1],
  3: [-1, 0],
  4: [-1, 1],
  5: [0, 1],
  6: [1, 1],
  7: [1, 0],
  8: [1, -1],
};

const DIAGONAL = [DIRECTION[2], DIRECTION[4], DIRECTION[6], DIRECTION[8]];

const solution = ([size, ...input]) => {
  const [N, M] = size.split(' ').map(Number);
  const bascket = input.slice(0, N).map((e) => e.split(' ').map(Number));
  const command = input.slice(N).map((e) => e.split(' ').map(Number));

  const move = ([r, c], s, [dr, dc]) => {
    let [nr, nc] = [r + dr * s, c + dc * s];
    while (nr < 0 || nc < 0) {
      nr += N;
      nc += N;
    }
    return [nr % N, nc % N];
  };

  let clouds = [
    [N - 2, 0],
    [N - 2, 1],
    [N - 1, 0],
    [N - 1, 1],
  ];
  command.forEach(([d, s]) => {
    // 이동
    const movedClouds = clouds.map((cloud) => move(cloud, s, DIRECTION[d]));
    const drain = bascket.map((row) => row.map((e) => e >= 2));

    // 비내리기
    movedClouds.forEach(([r, c]) => {
      bascket[r][c]++;
      drain[r][c] = false;
    });

    // 대각선 비내리기
    movedClouds.forEach(([r, c]) => {
      const rain = DIAGONAL.reduce((acc, [dr, dc]) => {
        const [nr, nc] = [r + dr, c + dc];
        if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
          return acc;
        }
        return acc + (bascket[nr][nc] > 0);
      }, 0);
      bascket[r][c] += rain;
    });

    // 물 흡수
    let nextClouds = [];
    drain.forEach((row, r) =>
      row.forEach((e, c) => {
        if (e) {
          bascket[r][c] -= 2;
          nextClouds.push([r, c]);
        }
      })
    );
    clouds = nextClouds;
  });

  return bascket.flat().reduce((acc, e) => acc + e, 0);
};
