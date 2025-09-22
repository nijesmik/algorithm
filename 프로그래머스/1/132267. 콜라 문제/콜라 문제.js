function solution(a, b, n) {
    let answer = 0;
    
    while (n >= a) {
        const bottle = Math.floor(n / a) * b;
        answer += bottle;
        n = bottle + n % a;
    }
    
    return answer;
}