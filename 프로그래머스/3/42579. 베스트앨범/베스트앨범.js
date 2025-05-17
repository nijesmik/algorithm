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
    
    return Object.values(genreMap)
                .sort((a, b) => b.play - a.play)
                .map((genre) => genre.list.sort((a, b) => b.play - a.play).slice(0, 2))
                .flat()
                .map((song) => song.index);
}