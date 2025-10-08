function solution(new_id) {
    let tmp_id = new_id
        .toLowerCase()
        .replace(/[^a-z0-9\-_.]/g, '')
        .replace(/[.]{2,}/g, '.')
        .replace(/^\.|\.$/g, '');
    
    tmp_id = !tmp_id ? 'a' : tmp_id.slice(0, 15).replace(/^\.|\.$/g, '');

    if (tmp_id.length < 3) {
        return tmp_id.padEnd(3, tmp_id.slice(-1));
    }
    return tmp_id;
}