function solution(t, p) {
    const num = Number(p);
    
    let answer = 0;
    for (let i = 0; i < t.length - p.length + 1; i++) {
        const substr = t.slice(i, i + p.length);
        if (Number(substr) <= num) {
            answer++;
        }
    }
    
    return answer;
}