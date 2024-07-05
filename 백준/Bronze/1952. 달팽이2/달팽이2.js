const fs = require('fs');
const [R, C] = fs.readFileSync('/dev/stdin').toString().trim().split(' ').map(Number);

const visited = Array.from(Array(R), () => Array(C).fill(false));

let n = R * C - 1;
let i = 0;
let j = 0;
let dir = 0;
const dr = [0, 1, 0, -1];
const dc = [1, 0, -1, 0];
let count = 0;

const isValid = (i, R) => {
    return i >= 0 && i < R;
}

while (n-- > 0) {
    visited[i][j] = true;
    const nr = i + dr[dir];
    const nc = j + dc[dir];
    if (!isValid(nr, R) || !isValid(nc, C) || visited[nr][nc]) {
        dir = (dir + 1) % 4;
        count++;
    }
    i += dr[dir];
    j += dc[dir];
}

console.log(count);
