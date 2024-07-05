const [N, target] = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n')
  .map(Number);

const board = Array.from(Array(N), () => Array(N).fill(0));
let num = N * N;
let r = 0;
let c = 0;
let dir = 0;
const dc = [0, 1, 0, -1];
const dr = [1, 0, -1, 0];
let answer = [];

while (num > 0) {
  board[r][c] = num;
  if (num === target) {
    answer = [r + 1, c + 1];
  }
  const nr = r + dr[dir];
  const nc = c + dc[dir];
  if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] > 0) {
    dir = (dir + 1) % 4;
  }
  r += dr[dir];
  c += dc[dir];
  num--;
}

console.log(board.map((row) => row.join(' ')).join('\n'));
console.log(answer.join(' '));
