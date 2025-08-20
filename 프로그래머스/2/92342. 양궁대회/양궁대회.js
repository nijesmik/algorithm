function solution(n, info) {
    const info_ryan = Array.from({length: 11}, () => 0);
    let answer = [-1];
    let max = 0;
    
    const compare = () => {
        let score_a = 0, score_r = 0;
        
        for (let i = 0; i < 11; i++) {
            if (!info[i] && !info_ryan[i]) {
                continue;
            }
            
            const point = 10 - i;
            if (info[i] >= info_ryan[i]) {
                score_a += point;
            } else {
                score_r += point;
            }
        }
        
        const diff = score_r - score_a
        if (diff > 0) {
            if (diff > max) {
                max = diff;
                answer = [...info_ryan];
            } else if (diff === max) {
                for (let i = 10; i >= 0; i--) {
                    if (answer[i] === info_ryan[i]) {
                        continue;
                    } else if (answer[i] < info_ryan[i]) {
                        answer = [...info_ryan];
                    }
                    return;
                }
            }
        }
    }
    
    const dfs = (k, depth) => {
        if (k === 0) {
            compare(info, info_ryan)
            return;
        }
        if (depth === 11) {
            return;
        }
        
        for (let i = k; i >= 0; i--) {
            info_ryan[depth] = i;
            dfs(k - i, depth + 1);
            info_ryan[depth] = 0;
        }
    }
        
    dfs(n, 0)
    
    return answer;
}