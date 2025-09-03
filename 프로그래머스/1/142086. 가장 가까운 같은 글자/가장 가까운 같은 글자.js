function solution(s) {
    const positions = {}
    
    return Array.from(s).map((char, index) => {
        const prevIdx = positions[char];
        positions[char] = index;
        return prevIdx === undefined ? -1 : index - prevIdx;
    });
}