function solution(commands) {
    const n = 50 * 50;
    const empty = 'EMPTY';
    const answer = [];
    const cells = new Array(n).fill(empty);    
    const parents = Array.from({length: n}, (_, i) => i);
    
    const getParent = (index) => {
        if (parents[index] === index) {
            return index;
        }
        const p = getParent(parents[index]);
        parents[index] = p;
        return p;
    }

    const index = (r, c) => (r - 1) * 50 + (c - 1);
    
    const updateAll = (params) => {
        const [prev, next] = params;
        cells.forEach((v, i) => {
            if (v === prev) {
                cells[i] = next;
            }
        })
    }
    
    const update = (params) => {
        if (params.length === 2) {
            return updateAll(params);
        }
        
        const [r, c, value] = params;
        const idx = getParent(index(Number(r), Number(c)));
        cells[idx] = value;
    }
    
    const print = (params) => {
        const [r, c] = params.map(Number);
        const idx = getParent(index(r, c));
        answer.push(cells[idx]);
    }
    
    const merge = (params) => {
        const [r1, c1, r2, c2] = params.map(Number);
        if (r1 === r2 && c1 === c2) {
            return;
        }
        
        const idx1 = getParent(index(r1, c1));
        const idx2 = getParent(index(r2, c2));
        const value = cells[idx1] === empty ? cells[idx2] : cells[idx1];
        parents[idx1] = idx2;
        cells[idx2] = value;
    }
    
    const unmerge = (params) => {
        const [r, c] = params.map(Number);
        const idx = index(r, c);
        const parent = getParent(idx);
        const value = cells[parent];
        
        const unmerged = [];
        parents.forEach((v, i) => {
            if (getParent(v) === parent) {
                cells[i] = empty;
                unmerged.push(i);
            }
        })
        unmerged.forEach((i) => parents[i] = i);
        cells[idx] = value;
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