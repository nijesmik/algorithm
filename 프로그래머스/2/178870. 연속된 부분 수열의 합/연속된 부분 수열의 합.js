function solution(sequence, k) {
    const n = sequence.length;
    let [st, ed] = [0, 0];
    let sum = sequence[0];
    let answer = null;
    
    const updateAnswer = ([st, ed]) => {
        if (!answer) {
            answer = [st, ed];
            return;
        }
        
        const len1 = ed - st;
        const len2 = answer[1] - answer[0];
        if (len1 < len2) {
            answer = [st, ed];
        }
    }
    
    while (st < n && ed < n) {
        if (sum > k) {
            sum -= sequence[st++];
        } else {
            if (sum === k) {
                updateAnswer([st, ed]);
            }
            sum += sequence[++ed];
        }
    }
    
    return answer;
}