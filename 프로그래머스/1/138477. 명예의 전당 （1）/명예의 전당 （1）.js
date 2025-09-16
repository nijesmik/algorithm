function solution(k, score) {
    const honor = [];
    
    return score.map((today) => {
        honor.push(today);
        honor.sort((a, b) => b - a);
        while (honor.length > k) {
            honor.pop();
        }
        return honor[honor.length - 1];
    })
}