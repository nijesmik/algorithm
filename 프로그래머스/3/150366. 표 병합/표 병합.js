function solution(commands) {
    const n = 50 * 50;
    const empty = 'EMPTY';
    const answer = [];
    const cells = Array.from({length: n}, (_, i) => ({value: empty}));

    const index = (r, c) => (r - 1) * 50 + (c - 1);
    
    const updateAll = (params) => {
        const [prev, next] = params;
        cells.forEach((cell) => {
            if (cell.value === prev) {
                cell.value = next;
            }
        })
    }
    
    const update = (params) => {
        if (params.length === 2) {
            return updateAll(params);
        }
        
        const [r, c, value] = params;
        cells[index(Number(r), Number(c))].value = value;
    }
    
    const print = (params) => {
        const [r, c] = params.map(Number);
        answer.push(cells[index(r, c)].value);
    }
    
    const replace = (from, to) => cells.forEach(
        (cell, i) => {
            if (cell === from) {
                cells[i] = to;
            }
        }
    )
    
    const merge = (params) => {
        const [r1, c1, r2, c2] = params.map(Number);
        if (r1 === r2 && c1 === c2) {
            return;
        }
        
        const cell1 = cells[index(r1, c1)];
        const cell2 = cells[index(r2, c2)];
        if (cell1.value === empty) {
            replace(cell1, cell2);
        } else {
            replace(cell2, cell1);
        }
    }
    
    const unmerge = (params) => {
        const [r, c] = params.map(Number);
        const idx = index(r, c);
        const unmerged = cells[idx];
        cells.forEach((cell, i) => {
            if (cell === unmerged) {
                cells[i] = {
                    value: empty,
                }
            }
        });
        cells[idx] = unmerged;
    }
    
    commands.forEach((cmd) => {
        const [command, ...params] = cmd.split(' ');
        switch (command) {
            case 'UPDATE':
                return update(params);
            case 'MERGE':
                return merge(params);
            case 'UNMERGE':
                return unmerge(params);
            case 'PRINT':
                return print(params);
        }
    })    
          
    return answer;
}