function solution(players, m, k) {
    let server = 1;
    let answer = 0;
    const map = new Map();
    
    players.forEach((player, time) => {
        // 반납 처리
        if (map.has(time)) {
            const returnCount = map.get(time).count;
            server -= returnCount;
        }
        
        while (player >= server * m) {
            answer++;
            server++;
            // k시간 후 반납 등록
            const returnTime = time + k;
            if (!map.has(returnTime)) {
                map.set(returnTime, {count: 0})
            }
            const returnServer = map.get(returnTime);
            returnServer.count++;
        }
    })
    

    return answer;
}