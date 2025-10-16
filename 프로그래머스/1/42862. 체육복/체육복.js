function solution(n, lost, reserve) {
    const stolen = new Array(n + 1).fill(false);
    lost.forEach((i) => stolen[i] = true);
    
    const canBorrow = new Array(n + 2).fill(false);
    reserve.forEach((i) => {
        if (!stolen[i]) {
            canBorrow[i] = true;
        } else {
            stolen[i] = false;
        }
    });
    
    const borrow = (i) => {
        const borrowed = canBorrow[i] ?? false;
        canBorrow[i] = false;
        return borrowed;
    }
    
    lost.sort((a, b) => a - b);
    return lost.reduce((answer, i) => {
        if (stolen[i] && !borrow(i - 1) && !borrow(i + 1)) {
            answer--;
        }
        return answer;
    }, n);
}