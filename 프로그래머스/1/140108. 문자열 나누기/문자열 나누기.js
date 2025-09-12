function solution(s) {
    let x = s[0];
    let words = 0;
    const count = [0, 0];
    
    for (let char of s) {
        if (count[0] === count[1]) {
            words++;
            x = char;
        }
        
        count[Number(x === char)]++;                
    }
    
    return words;
}