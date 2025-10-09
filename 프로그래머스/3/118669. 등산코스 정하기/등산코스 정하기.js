function solution(n, paths, gates, summits) {
    const inf = 10_000_000 + 1;
    
    const isSummit = new Array(n + 1).fill(false);
    summits.forEach((i) => isSummit[i] = true);
    
    const graph = Array.from({length: n + 1}, () => []);
    paths.forEach(([i, j, w]) => {
        graph[i].push([j, w]);
        graph[j].push([i, w]);
    })
    
    const intensity = new Array(n + 1).fill(inf);
    const stack = [];
    const push = (i, w) => {
        intensity[i] = w;
        stack.push([i, w]);
    }
    
    gates.forEach((gate) => push(gate, 0));

    let min = inf;
    while (stack.length !== 0) {
        const [curr, cw] = stack.pop();
        if (isSummit[curr]) {
            min = Math.min(cw, min);
            continue;
        }
        if (cw > intensity[curr]) {
            continue;
        }
        graph[curr].forEach(([next, nw]) => {
            const w = Math.max(nw, cw);
            if (w < intensity[next] && w <= min) {
                push(next, w);
            }
        })
    }
    
    summits.sort((a, b) => a - b);
    return summits.reduce((answer, summit) => {
        const w = intensity[summit];
        return w < answer[1] ? [summit, w] : answer;
    }, [0, inf]);
}