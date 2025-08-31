function solution(info, query) {
    const map = new Map();
    
    const addScore = (key, score) => {
        if (!map.has(key)) {
            map.set(key, []);
        }
        map.get(key).push(score);
    }
    
    const dfs = (depth, types, score) => {
        if (depth === 4) {
            addScore(types.join(''), score);
            return;
        }
        
        dfs(depth + 1, types, score);
        const t = [...types];
        t[depth] = '-';
        dfs(depth + 1, t, score);
    }
    
    info.forEach((applicant) => {
        const types = applicant.split(" ");
        const score = Number(types.pop());
        dfs(0, types, score);        
    });

    for (const scores of map.values()) {
        scores.sort((a, b) => a - b);
    }
    
    const bs = (scores, target) => {
        let start = 0;
        let end = scores.length;
        
        while (start < end) {
            const mid = Math.floor((start + end) / 2);
            if (scores[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return scores.length - start;
    }
    
    return query.map((q) => {
        const types = q.replace(/and\s/g, "").split(" ");
        const target = Number(types.pop());
        const scores = map.get(types.join('')) ?? [];
        return bs(scores, target);
    });
}