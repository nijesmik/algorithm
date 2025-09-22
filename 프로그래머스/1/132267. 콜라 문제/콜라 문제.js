function solution(a, b, n) {
    const answer = new Array(n + 1).fill(0);
    
    for (let i = 2; i <= n; i++) {
        const bottle = Math.floor(i / a) * b;
        answer[i] = bottle + answer[bottle + i % a];
    }
    
    return answer[n];
}