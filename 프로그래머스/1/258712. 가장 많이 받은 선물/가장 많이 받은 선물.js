function solution(friends, gifts) {
    const N = friends.length;
    const indexMap = new Map(friends.map((name, index) => [name, index]));
    const point = Array.from({length: N}, () => new Array(N).fill(0));
    const pointSum = new Array(N).fill(0);
    
    gifts.forEach((gift) => {
        const [from, to] = gift.split(" ").map((name) => indexMap.get(name));
        point[from][to]++;
        pointSum[from]++;
        pointSum[to]--;
    })
    
    const expect = point.map((sent, i) => sent.reduce((expected, point_sent, j) => {
        const pointDiff = point_sent - point[j][i];
        const pointSumDiff = pointSum[i] - pointSum[j];
        
        if (pointDiff > 0 || (!pointDiff && pointSumDiff > 0)) {
            return expected + 1;
        }
        return expected;
    }, 0));
    
    return Math.max(...expect);
}