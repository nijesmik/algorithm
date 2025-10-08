function solution(new_id) {
    const tmp_id = new_id
        .toLowerCase()
        .replace(/[^\w\-_.]/g, '')
        .replace(/\.+/g, '.')
        .replace(/^\.|\.$/g, '')
        .padEnd(1, 'a')
        .slice(0, 15).replace(/^\.|\.$/g, '');

    return tmp_id.padEnd(3, tmp_id.slice(-1));
}