function solution(left, right) {
    let answer = 0
    for (let n = left; n <= right; n++) {
        const sign = Math.sqrt(n) % 1 === 0 ? -1 : 1;
        answer += sign * n;
    }
    return answer;
}