const delta = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1],
]

function solution(maze) {
    const sizeR = maze.length;
    const sizeC = maze[0].length;
    
    const visited = Array.from({length: sizeR}, () => new Array(sizeC).fill(0));
    let startR = [];
    let startB = [];
    let endR = [];
    let endB = [];
    maze.forEach((row, i) => row.forEach((x, j) => {
        switch (x) {
            case 1: {
                startR = [i, j];
                visited[i][j] = 1;
                return;
            }
            case 2: {
                startB = [i, j];
                visited[i][j] = 2;
                return;
            }
            case 3: {
                endR = [i, j];
                return;
            }
            case 4: {
                endB = [i, j];
                return;
            }
            case 5: {
                visited[i][j] = 3;
                visited[i][j] = 3;
                return;
            }
        }
    }));
    
    const outofSize = (r, c) => r < 0 || c < 0 || r >= sizeR || c >= sizeC;
    const copy = (map) => map.map((row) => [...row]);
    const isEqual = (pos1, pos2) => pos1[0] === pos2[0] && pos1[1] === pos2[1];
    const move = (pos, delta, end) => {
        if (isEqual(pos, end)) {
            return end;
        }
        return [pos[0] + delta[0], pos[1] + delta[1]];
    }
    const isVisited = (pos, v, end, bit) => {
        if (isEqual(pos, end)) {
            return false;
        }
        return v[pos[0]][pos[1]] & bit;
    }
    
    const queue = [[startR, startB, visited, 0]];
    let qi = 0;
    while (qi < queue.length) {
        const [r, b, v, time] = queue[qi++];
        if (isEqual(r, endR) && isEqual(b, endB)) {
            return time;
        }
        
        delta.forEach((d) => {
            const nr = move(r, d, endR);
            if (outofSize(...nr) || isVisited(nr, v, endR, 1)) {
                return;
            }
            
            delta.forEach((d) => {
                const nb = move(b, d, endB);
                if (outofSize(...nb) || isVisited(nb, v, endB, 2) || (isEqual(nr, b) && isEqual(nb, r)) || isEqual(nr, nb)) {
                    return;
                }
                
                const visited = copy(v);
                visited[nr[0]][nr[1]] |= 1;
                visited[nb[0]][nb[1]] |= 2;
                queue.push([nr, nb, visited, time + 1]);
            })
        })
    }
    
    return 0;
}