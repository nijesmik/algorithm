function solution(plans) {
    plans = plans.map(([name, start, take]) => {
        const [hh, mm] = start.split(":").map(Number);
        return [name, hh * 60 + mm, Number(take)];
    }).sort((a, b) => a[1] - b[1])
    
    const answer = [];
    const wip = [];
    
    for (const [curr, start, take] of plans) {
        while (wip.length > 0 && wip[wip.length - 1][1] <= start) {
            const [done] = wip.pop();
            answer.push(done);
        }
        
        wip.forEach((_, i) => wip[i][1] += take);
        wip.push([curr, start + take]);
    }
    
    let n = wip.length;
    while (n-- > 0) {
        answer.push(wip[n][0]);
    }
    
    return answer;
}