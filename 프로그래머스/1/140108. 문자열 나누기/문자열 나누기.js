function solution(s) {
    let x = s[0];
    let words = -1;
    let making = [];
    const count = [0, 0];
    
    for (let char of s) {
        if (count[0] === count[1]) {
            words++;
            making = [];
            x = char;
        }
        
        making.push(char);
        count[Number(x === char)]++;                
    }
    
    return words + (making.length ? 1 : 0);
}