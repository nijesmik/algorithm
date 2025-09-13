function solution(s, skip, index) {
    const skipped = new Set(Array.from({length: skip.length}, (_, i) => skip.charCodeAt(i)));
    const map = new Map();
    const start = 'a'.charCodeAt(0);
    
    for (let i = 0; i < 26; i++) {
        let offset = 0;
        let n = 1;
        while (n <= index) {
            if (skipped.has(start + (i + n + offset) % 26)) {
                offset++;
            } else {
                n++;
            }
        } 
        map.set(String.fromCharCode(start + i), String.fromCharCode(start + (i + index + offset) % 26));
    }
    
    return Array.from(s).map((char) => map.get(char)).join('');
}