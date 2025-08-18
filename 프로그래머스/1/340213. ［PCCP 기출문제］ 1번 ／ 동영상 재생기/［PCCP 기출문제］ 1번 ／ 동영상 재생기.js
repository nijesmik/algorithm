const parseTime = (time) => {
    const [mm, ss] = time.split(":").map(Number);
    
    return mm * 60 + ss;
}

function solution(video_len, pos, op_start, op_end, commands) {
    const video_time = parseTime(video_len);
    const op_start_time = parseTime(op_start);
    const op_end_time = parseTime(op_end);
    
    const isOpening = (time) => op_start_time <= time && time <= op_end_time;
    
    const moved_time = commands.reduce((time, cmd) => {
        if (isOpening(time)) {
            time = op_end_time;
        }
        
        if (cmd === "prev") {
            const current = time - 10;
            return current < 0 ? 0 : current;
        }
        
        // cmd === "next"
        const current = time + 10;
        return current > video_time ? video_time : current;
    }, parseTime(pos));
    
    if (isOpening(moved_time)) {
        return op_end;
    }
    
    return [Math.floor(moved_time / 60), moved_time % 60]
            .map((n) => n.toString())
            .map((s) => s.padStart(2, '0'))
            .join(":");
}