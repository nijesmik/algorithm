function solution(keymap, targets) {
    const map = new Map();
    keymap.forEach((keys) => {
        for (let i = 0; i < keys.length; i++) {
            const key = keys[i];
            const count = map.get(key) ?? 101;
            if (i + 1 < count) {
                map.set(key, i + 1);
            }
        }
    })
    
    return targets.map((keys) => {
        let sum = 0;
        for (let i = 0; i < keys.length; i++) {
            const key = keys[i];
            if (!map.has(key)) {
                return -1;
            }
            sum += map.get(key);
        }
        return sum;
    });
}