function solution(k, score) {
    const answer = [];
    const honor = [];
    
    const peek = () => honor[honor.length - 1];
    
    const push = (score) => {
        honor.push(score);
        honor.sort((a, b) => b - a);
        while (honor.length > k) {
            honor.pop();
        }
    }
    
    for (const today of score) {
        push(today);
        answer.push(peek());
    }
    
    return answer;
}