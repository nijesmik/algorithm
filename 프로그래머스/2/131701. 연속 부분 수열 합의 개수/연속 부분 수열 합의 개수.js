function solution(elements) {
    const seq = elements.concat(elements);
    const set = new Set(elements);
    const acc = elements.reduce((acc, elem, i) => {
        acc[i + 1] = elem + acc[i];
        return acc;
    }, [0])
    
    for (let len = 2; len <= elements.length; len++) {
        let sum = acc[len];
        set.add(sum);
        for (let idx = 0; idx < elements.length; idx++) {
            sum = sum - seq[idx] + seq[idx + len];
            set.add(sum);
        }
    }

    return set.size;
}