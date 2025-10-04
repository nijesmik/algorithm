const init = (maps, sizeR, sizeC) => {
    const v = Array.from({length: sizeR}, () => new Array(sizeC).fill(false));
    let s = [];
    let e = [];
    let l = [];
    
    maps.forEach((row, i) => {
        for (let j = 0; j < sizeC; j++) {
            switch (row[j]) {
                case 'S':
                    s = [i, j];
                    continue;
                case 'E':
                    e = [i, j];
                    continue;
                case 'L':
                    l = [i, j];
                    continue;
                case 'X':
                    v[i][j] = true;
            }
        }
    });
    
    return {v, s, e, l};
}

const delta = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1],
]

function solution(maps) {
    const sizeR = maps.length;
    const sizeC = maps[0].length;
    const {v, s, e, l} = init(maps, sizeR, sizeC);
    
    const copy = (arr) => arr.map((row) => [...row]); 
    
    const canGo = (r, c) => 0 <= r && r < sizeR && 0 <= c && c < sizeC;
    
    const bfs = (start, end) => {
        const visited = copy(v);
        const queue = [];
        let idxQ = 0;
        
        const move = (r, c, time) => {
            visited[r][c] = true;
            queue.push([r, c, time]);
        }
        
        move(...start, 1);
        while (idxQ < queue.length) {
            const [r, c, time] = queue[idxQ++];
            
            for (const [dr, dc] of delta) {
                const [nr, nc] = [r + dr, c + dc];
                if (canGo(nr, nc) && !visited[nr][nc]) {
                    if (nr === end[0] && nc === end[1]) {
                        return time;
                    }
                    move(nr, nc, time + 1);
                }
            }
        }
        return -1;
    }
    
    const time1 = bfs(s, l);
    if (time1 === -1) return -1;
    
    const time2 = bfs(l, e);
    if (time2 === -1) return -1;
    
    return time1 + time2;
}