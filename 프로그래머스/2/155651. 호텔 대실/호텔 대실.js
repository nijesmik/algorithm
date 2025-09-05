function solution(book_time) {
    book_time = book_time.map(([start, end]) => {
        const [hh_start, mm_start] = start.split(":").map(Number);
        start = hh_start * 60 + mm_start;
        
        const [hh_end, mm_end] = end.split(":").map(Number);
        end = hh_end * 60 + mm_end;
        
        return [start, end];
    }).sort(([a], [b]) => a - b);
    
    const rooms = [0];
    
    book_time.forEach(([start, end]) => {
        const room = rooms[0];
        
        if (room <= start) {
            rooms[0] = end + 10;
        } else {
            rooms.push(end + 10);
        }
        rooms.sort((a, b) => a - b);
    })
    
    return rooms.length;
}