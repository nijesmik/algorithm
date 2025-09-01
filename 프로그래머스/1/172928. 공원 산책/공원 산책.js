const DIRECTION = {
    'N': [-1, 0],
    'S': [1, 0],
    'W': [0, -1],
    'E': [0, 1],
}

function solution(park, routes) {
    let position;
    
    park.forEach((row, i) => {
        for (let j = 0; j < row.length; j++) {
            const type = row[j];
            if (type === 'S') {
                position = [i, j];
            }
        }
    })
    
    const isValid = (r, c) => 0 <= r && r < park.length && 0 <= c && c < park[0].length;
    
    routes.forEach((cmd) => {
        const [op, num] = cmd.split(' ');
        let n = Number(num);
        let [r, c] = position;
        const [dr, dc] = DIRECTION[op];
        
        if (!isValid(r + dr * n, c + dc * n)) {
            return;
        }
        
        while (n-- > 0) {
            r += dr;
            c += dc;
            if (park[r][c] === 'X') {
                return;
            }
        }
        position = [r, c];
    })
    
    return position;
}