function solution(players, callings) {
    const playerToRank = new Map(players.map((name, i) => [name, i]));
    
    callings.forEach((name) => {
        const rank = playerToRank.get(name);
        const passed = players[rank - 1];
        
        players[rank] = passed;
        players[rank - 1] = name;
        
        playerToRank.set(name, rank - 1);
        playerToRank.set(passed, rank);
    })
    
    return players;
}