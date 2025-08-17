const getPosition = (num, w) => {
    num--;
    const row = Math.floor(num / w);
    const col = num % w;
    if (row % 2 == 1) {
        return [row, w - 1 - col];
    }
    return [row, col]
}

function solution(n, w, num) {
    const [row, col] = getPosition(num, w);
    const [top_r, top_c] = getPosition(n, w);
    
    const answer = top_r - row + 1;
    if ((col < top_c && top_r % 2 == 1) || (top_c < col && top_r % 2 == 0) ) {
        return answer - 1;       
    }
    return answer;
}