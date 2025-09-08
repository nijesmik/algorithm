function solution(elements) {
    const seq = [...elements, ...elements];
    const set = new Set(elements);
    const acc = elements.reduce((acc, elem, i) => {
        const prev = acc[i - 1] ?? 0;
        acc[i] = elem + prev;
        return acc;
    }, [])
    
    for (let len = 2; len <= elements.length; len++) {
        let sum = acc[len - 1];
        set.add(sum);
        for (let idx = 0; idx < elements.length; idx++) {
            sum -= seq[idx];
            sum += seq[idx + len];
            set.add(sum);
        }
    }

    return set.size;
}