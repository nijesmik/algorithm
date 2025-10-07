function solution(absolutes, signs) {
    return absolutes.reduce((acc, num, i) => {
        const sign = signs[i] ? 1 : -1;
        return acc + sign * num;
    }, 0);
}