function solution(X, Y) {
    const countX = new Array(10).fill(0);
    const countY = new Array(10).fill(0);

    Array.from(X).map(Number).forEach((x) => countX[x]++);
    Array.from(Y).map(Number).forEach((y) => countY[y]++);
    
    const result = [];
    for (let i = 9; i >= 0; i--) {
        const pair = Math.min(countX[i], countY[i]);
        if (pair) {
            result.push(i.toString().repeat(pair));   
        }
    }
    
    if (!result.length) {
        return '-1';        
    }

    if (result[0] == 0) {
        return '0';
    }

    return result.join('');
}