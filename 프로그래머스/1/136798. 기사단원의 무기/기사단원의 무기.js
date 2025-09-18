const getPrimeList = (n) => {
    const isPrime = new Array(n + 1).fill(true);
    
    isPrime[0] = false;
    isPrime[1] = false;
    
    for (let i = 2; i * i <= n; i++) {
        if (!isPrime[i]) {
            continue;
        }
        for (let j = i * 2; j <= n; j += i) {
            isPrime[j] = false;
        }
    }
    
    return isPrime.reduce((prime, bool, num) => {
        if (bool) {
            prime.push(num);
        }
        return prime;
    }, []);
}

function solution(number, limit, power) {
    const primeList = getPrimeList(number);
    
    return Array.from({length: number}, (_, i) => {
        let num = i + 1;
        let total = 1;
        for (const prime of primeList) {
            if (prime > num) {
                return total;
            }
            
            let count = 0;
            while (num % prime === 0) {
                num = Math.floor(num / prime);
                count++;
            }
            total *= count + 1;
        }
        
        return total;
    }).reduce((acc, divisor) => acc + (divisor > limit ? power : divisor));
}