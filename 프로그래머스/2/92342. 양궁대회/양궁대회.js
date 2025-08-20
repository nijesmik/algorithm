function solution(n, info) {
    const info_ryan = Array.from({length: 11}, () => 0);
    let answer = [-1];
    let maxDiff = 0;
    
    const getDiff = (i) => {
        if (!info[i] && !info_ryan[i]) {
            return 0;
        }
        const point = 10 - i;
        return info[i] >= info_ryan[i] ? -point : point;
    }
    
    const compare = (diff) => {        
        if (diff <= 0 || diff < maxDiff) {
            return;
        }
        
        if (diff > maxDiff) {
            maxDiff = diff;
            answer = [...info_ryan];
            return;
        }
        
        // diff === maxDiff
        for (let i = 10; i >= 0; i--) {
            if (answer[i] === info_ryan[i]) {
                continue;
            } else if (answer[i] < info_ryan[i]) {
                answer = [...info_ryan];
            }
            return;
        }
    }
    
    const dfs = (k, depth, diff) => {
        if (depth === 11) {
            if (k === 0) compare(diff);
            return;
        }
        
        for (let i = k; i >= 0; i--) {
            info_ryan[depth] = i;
            dfs(k - i, depth + 1, diff + getDiff(depth));
            info_ryan[depth] = 0;
        }
    }
        
    dfs(n, 0, 0);
    
    return answer;
}