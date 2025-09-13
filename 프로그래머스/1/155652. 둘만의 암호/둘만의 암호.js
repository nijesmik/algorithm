function solution(s, skip, index) {
    const skipped = new Set(skip);
    const code_a = 'a'.charCodeAt(0);
    
    const alphabets = [];
    for (let i = 0; i < 26; i++) {
        const char = String.fromCharCode(code_a + i);
        if (!skipped.has(char)) {
            alphabets.push([char, alphabets.length]);
        }
    }
    
    const map = new Map(alphabets);
    
    return Array.from(s).map((char) => alphabets[(map.get(char) + index) % alphabets.length][0]).join('');
}