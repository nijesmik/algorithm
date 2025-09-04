function solution(n, m, section) {
    let count = 0;
    let painted = -1;
    
    for (let index of section) {
        if (painted < index) {
            count++;
            painted = index + m - 1;
        }
    }
        
    return count;
}