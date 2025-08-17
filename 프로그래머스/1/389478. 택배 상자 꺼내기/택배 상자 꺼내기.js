const getPosition = (num, w) => {
    const row = Math.floor(num / w);
    const col = (num - 1) % w;
    if (row % 2 == 1) {
        return [row, w - 1 - col];
    }
    return [row, col]
}

function solution(n, w, num) {
    const [row, col] = getPosition(num, w);
    
    let top_num = num;
    let top_row = row;
    
    while (top_num <= n) {
        if (top_row % 2 == 1) {
            top_num += col * 2 + 1;
        } else {
            top_num += (w - 1 - col) * 2 + 1;
        }
        top_row++;
    }
    
    return top_row - row;
}