function solution(food) {
    const placement = food.reduce((arr, amount, index) => {
        arr.push(index.toString().repeat(Math.floor(amount / 2)));
        return arr;
    }, []);
    
    return [placement.join(''), placement.reverse().join('')].join('0');
}