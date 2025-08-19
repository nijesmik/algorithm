function solution(queue1, queue2) {
    const N = queue1.length * 2;
    let sum1 = queue1.reduce((s, n) => s + n, 0);
    let sum2 = queue2.reduce((s, n) => s + n, 0);
    
    let count = 0, index1 = 0, index2 = 0;
    while (sum1 !== sum2) {
        if (sum1 < sum2) {
            if (index2 >= N) return -1;
            const popped = queue2[index2++];
            queue1.push(popped);
            sum1 += popped;
            sum2 -= popped;
        } else {
            if (index1 >= N) return -1;
            const popped = queue1[index1++];
            queue2.push(popped);
            sum2 += popped;
            sum1 -= popped;
        }
        count++;
    }
    return count;   
}