function solution(s) {
    const answer = [0, 0];

    while (s !== "1") {
        const length = s.length;
        s = s.replaceAll("0", "");
        const one = s.length;
        s = one.toString(2);
        answer[0]++;
        answer[1] += length - one;
    }
    
    return answer;
}