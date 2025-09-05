const parseTime = (time) => {
    const [hh, mm] = time.split(":").map(Number);
    return hh * 60 + mm;
}

function solution(book_time) {
    const rooms = [0];
    
    book_time
        .map((times) => times.map(parseTime))
        .sort(([a], [b]) => a - b)
        .forEach(([start, end]) => {
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