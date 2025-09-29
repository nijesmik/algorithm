function solution(numbers) {
    const exist = new Array(10).fill(false);
    
    numbers.forEach((n) => {
        exist[n] = true;
    });
    
    return exist.reduce((sum, isExist, n) => {
        if (!isExist) {
            sum += n;
        }
        return sum;
    }, 0);
}