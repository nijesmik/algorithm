function solution(schedules, timelogs, startday) {
    startday--;
    
    return schedules.filter((preferred, i) => {
        let h = Math.floor(preferred / 100);
        const m = preferred % 100 + 10;
        if (m >= 60) {
            h++;
        }
        const required = h * 100 + m % 60;
        
        return timelogs[i].filter((log, day) => (day + 7 + startday) % 7 < 5)
            .filter((log) => log <= required).length == 5;
    }).length;
}