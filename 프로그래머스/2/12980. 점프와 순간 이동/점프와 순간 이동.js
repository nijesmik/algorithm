function solution(n) {
    let usage = 0;

    while (n > 1) {
        if (n % 2 == 1) {
            usage++;
            n -= 1;
        }
        n /= 2;
    }
    
    return usage + 1;
}