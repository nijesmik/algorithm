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

const solution = ([size, input]) => {
  const N = Number(size);
  let numbers = input.split(' ').map(Number);

  const dp = Array.from({ length: N - 1 }, () => new Array(21).fill(0n));
  dp[0][numbers[0]] = 1n;

  for (let i = 1; i < N - 1; ++i) {
    const number = numbers[i];
    const push = (n, count) => {
      if (n >= 0 && n <= 20) {
        dp[i][n] += count;
      }
    };

    dp[i - 1].forEach((count, sum) => {
      push(sum + number, count);
      push(sum - number, count);
    });
  }

  return "" + dp[N - 2][numbers[N - 1]];
};
