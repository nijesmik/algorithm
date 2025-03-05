let R, C, queue, visited, oil, sum;

const validate = (i, j) => 0 <= i && i < R && 0 <= j && j < C;

const push = (i, j) => {
    queue.push([i, j]);
    visited[i][j] = true;
    oil.add(j);
    sum++;
}

const dr = [1, -1, 0, 0];
const dc = [0, 0, 1, -1];

function solution(land) {
    R = land.length;
    C = land[0].length;
    
    const answer = Array.from({length: C}).fill(0);
    visited = Array.from({length: R}, () => Array.from({length: C}).fill(false) );
    
    queue = [];
    let index_q = 0;
    
    for (let i = 0; i < R; i++) {
        for (let j = 0; j < C; j++) {
            
            
            if (!visited[i][j] && land[i][j]) {
                oil = new Set();
                sum = 0;
                
                // bfs
                push(i, j);
                
                while (index_q < queue.length) {
                    const [r, c] = queue[index_q];
                    for (let k = 0; k < 4; k++) {
                        const nr = r + dr[k];
                        const nc = c + dc[k];
                        if (validate(nr, nc) && !visited[nr][nc] && land[nr][nc]) {
                            push(nr, nc);
                        }
                    }
                    index_q++;
                }
                
                oil.forEach((c) => {
                    answer[c] += sum;
                })
                
            }
            
            
        }
    }
    
    let max = 0;
    answer.forEach((v) => max = Math.max(v, max));
    

    return max;
}