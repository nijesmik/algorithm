const getTime = (h, m ,s) => {
    return (s + m * 60 + h * 60 * 60);
}

const compareTime = ([h1, m1, s1], [h2, m2, s2]) => {
    const time1 = getTime(h1, m1, s1);
    const time2 = getTime(h2, m2, s2);
    
    if (time1 < time2) {
        return -1;
    } else if (time1 == time2) {
        return 0;
    }
    return 1;
}

function solution(h1, m1, s1, h2, m2, s2) {
    const start = [h1, m1, s1];
    const end = [h2, m2, s2];
    
    let answer = 0;
    let h = h1;
    let m = m1;
    while (compareTime([h, m, 0], end) <= 0) {
        let match = 0;
        
        // s = m + s / 60
        // 60s = 60m + s
        const time1 = [h, m, 60 * m / 59];
        if (time1[2] < 60 && compareTime(start, time1) <= 0 && compareTime(time1, end) <= 0) {
            match++;
        }
        
        // s = (h + m / 60 + s / 3600) * 5
        // 3600s = (3600h + 60s) * 5 + 5s
        const time2 = [h, m, (3600 * (h % 12) + 60 * m) * 5 / 3595];
        if (time2[2] < 60 && compareTime(start, time2) <= 0 && compareTime(time2, end) <= 0) {
            match++;
        }
        
        if (match == 2 && time1[2] === time2[2]) {
            match = 1;
        }
        answer += match;
        
        m++;
        h += Math.floor(m / 60);
        m %= 60;
    }
    
    return answer;
}