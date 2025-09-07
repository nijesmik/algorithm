function solution(k, n, reqs) {
    const consult = Array.from({length: k}, () => []);
    reqs.forEach((req) => {
        const type = req[2] - 1;
        consult[type].push(req);
    })
    
    const dp = Array.from({length: k}, () => new Array(n - k + 1).fill(0))
        .map((row, type) => row.map((_, i) => {
            const teacher = new Array(i + 1).fill(0);
            return consult[type].reduce((sum, [arrive, take]) => {
                const end = teacher[0];
                const wait = end === 0 ? 0 : Math.max(0, end - arrive);
                teacher[0] = Math.max(arrive, end) + take;
                teacher.sort((a, b) => a - b);
                return sum + wait;
            }, 0)
        }))
    
    let min = Infinity;
    const comb = new Array(k).fill(0);
    const dfs = (type, sum) => {
        if (sum === n && type === k) {   
            const time = comb.reduce((sum, cnt, type) => sum + dp[type][cnt - 1], 0);
            min = Math.min(min, time);
            return;
        }
        if (type >= k || sum > n) {
            return;
        }

        
        for (let i = 1; i <= n - k + 1; i++) {
            comb[type] = i;
            dfs(type + 1, sum + i);
            comb[type] = 0;
        }
    }
    
    dfs(0, 0);
    
    return min;
}
