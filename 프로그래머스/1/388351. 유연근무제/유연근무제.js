const getTime = (schedule) => Math.floor(schedule / 100) * 60 + schedule % 100;

function solution(schedules, timelogs, startday) {
    startday--;
    
    return schedules
        .map((s) => getTime(s) + 10)
        .filter((s, i) => timelogs[i]
                .filter((log, day) => (day + 7 + startday) % 7 < 5)
                .filter((log) => getTime(log) <= s).length == 5
    ).length;
}