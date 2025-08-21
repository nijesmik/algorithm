function solution(friends, gifts) {
    const N = friends.length;
    const indexMap = new Map(friends.map((name, index) => [name, index]));
    const point = Array.from({length: N}, () => new Array(N).fill(0));
    
    gifts.forEach((gift) => {
        const [from, to] = gift.split(" ").map((name) => indexMap.get(name));
        point[from][to]++;
    })
    
    const pointSum = point
            .map((sent) => sent.reduce((a, c) => a + c), 0)
            .map((sum_sent, index) => {
                let sum_received = 0;
                for (let j = 0; j < N; j++) {
                    sum_received += point[j][index];
                }
                return sum_sent - sum_received;
            });
    
    return point.map((sent, i) => sent.reduce((expected, point_sent, j) => {
        const pointDiff = point_sent - point[j][i];
        const pointSumDiff = pointSum[i] - pointSum[j];
        
        if (pointDiff > 0 || (!pointDiff && pointSumDiff > 0)) {
            return expected + 1;
        }
        return expected;
    }, 0)).reduce((ans, e) => Math.max(ans, e), 0);
}