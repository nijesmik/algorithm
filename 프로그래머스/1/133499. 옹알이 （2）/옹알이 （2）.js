function solution(babbling) {
    return babbling.reduce((ans, bab) => {
        const filtered = bab
            .replace(/(ayaaya|yeye|woowoo|mama)/g, '.')
            .replace(/(aya|ye|woo|ma)/g, '')

        if (filtered === '') {
            return ans + 1;
        }
        return ans;
    }, 0);
}