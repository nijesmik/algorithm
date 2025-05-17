function solution(genres, plays) {
    const genreMap = genres.reduce((map, genre, index) => {
        if (!map[genre]) {
            map[genre] = {
                play: 0,
                list: [],
            }
        }
        play = plays[index]
        map[genre].play += play;
        map[genre].list.push({
            index,
            play,
        })
        return map;
    }, {});
    
    const rank = Object.values(genreMap).sort((a, b) => b.play - a.play)
    rank.forEach((genre) => genre.list.sort((a, b) => b.play - a.play))
        
    const answer = rank.map((genre) => genre.list.slice(0, 2)
                            .map((song) => song.index)).flat()
    
    return answer;
}