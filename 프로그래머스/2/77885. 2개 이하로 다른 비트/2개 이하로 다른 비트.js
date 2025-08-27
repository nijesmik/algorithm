function solution(numbers) {
    return numbers.map((num) => {
        const n = BigInt(num);
        if (n % 2n === 0n) {
            return n + 1n;
        }

        let bit = 1n;
        while ((n & bit) > 0n) {
            bit <<= 1n;
        }
        return n + bit - (bit >> 1n);
    })
}