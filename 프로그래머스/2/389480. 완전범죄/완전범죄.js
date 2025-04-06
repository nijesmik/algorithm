function solution(info, n, m) {
    const INF = 121;
    const queue = [{ depth: 0, a: 0, b: 0}];
    let index = 0;
    let min = INF;
    const memo = new Set();
    
    while (index < queue.length) {
        const { depth, a, b } = queue[index];
        index++;
        
        if (depth === info.length) {
            min = Math.min(a, min);
            continue;
        }
        
        const na = a + info[depth][0];
        const keyA = `${depth}-${na}-${b}`
        if (na < n && a < min && !memo.has(keyA)) {
            memo.add(keyA);
            queue.push({
                depth: depth + 1,
                a: na,
                b,
            });    
        }
        
        const nb = b + info[depth][1];
        const keyB = `${depth}-${a}-${nb}`
        if (nb < m) {
            memo.add(keyB);
            queue.push({
                depth: depth + 1,
                a,
                b: b + info[depth][1],
            })    
        }
        
    }
    
    return min === INF ? -1 : min;
}