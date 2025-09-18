function solution(number, limit, power) {
    const getPower = (n) => {
        let count = 0;
        for (let i = 1; i * i <= n; i++) {
            if (count > limit) {
                return power;
            }
            if (n % i === 0) {
                count += 2;
            }
            if (i * i === n) {
                count -= 1;
            }
        }
        return count > limit ? power : count;
    }
    
    let answer = 1;
    for (let i = 2; i <= number; i++) {
        answer += getPower(i);
    }
    
    return answer;
}