function solution(name, yearning, photo) {
    const map = new Map(name.map((n, i) => [n, yearning[i]]));
    
    return photo.map((names) => names.reduce((sum, n) => sum + (map.has(n) ? map.get(n) : 0), 0));
}