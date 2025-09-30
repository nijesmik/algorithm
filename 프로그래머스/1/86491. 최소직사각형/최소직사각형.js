function solution(sizes) {
    let [w, h] = [0, 0];
    for (const [s1, s2] of sizes) {
        w = Math.max(w, Math.max(s1, s2));
        h = Math.max(h, Math.min(s1, s2));
    }
    return w * h;
}