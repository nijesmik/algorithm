const answer = (start, end, size) => {
    return end < size ? -1 : start + end - size;
}

const find = (queue, target) => {
    let start = 0;
    let end = 0;
    let sum = queue[0];
    
    while (start < queue.length) {
        if (sum === target) {
            console.log(start, end)
            return answer(start, end, Math.floor(queue.length / 2) - 1);
        } else if (sum < target) {
            end++;
            if (end >= queue.length) {
                return -1;
            }
            sum += queue[end];
        } else {
            sum -= queue[start];
            start++;
        }
    }
    
    return -1;
}

function solution(queue1, queue2) {
    const sum1 = queue1.reduce((s, n) => s + n, 0);
    const sum2 = queue2.reduce((s, n) => s + n, 0);
    const target = Math.floor((sum1 + sum2) / 2);
    
    const answer1 = find([...queue1, ...queue2], target);
    const answer2 = find([...queue2, ...queue1], target);
    
    return answer1 == -1 || answer2 == -1 ? Math.max(answer1, answer2) : Math.min(answer1, answer2)
}