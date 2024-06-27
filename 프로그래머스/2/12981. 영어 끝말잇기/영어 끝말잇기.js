function solution(n, words) {
    const set = new Set();
    
    for (let i = 1; i < words.length; i++) {
        set.add(words[i - 1]);
    
        if (words[i - 1].slice(-1) !== words[i][0] ||
            set.has(words[i]) ||
            words[i].length === 1) {
            return [i % n + 1, Math.floor(i / n) + 1];
        }
    }
    
    return [0, 0];
}
