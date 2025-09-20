function solution(food) {
    const place = food.reduce((arr, amount, index) => {
        const n = Math.floor(amount / 2);
        if (n) {
            arr.push(index.toString().repeat(n));
        }
        return arr;
    }, []);
    
    let n = place.length;
    place.push('0');
    while (--n >= 0) {
        place.push(place[n]);
    }
    
    return place.join('');
}