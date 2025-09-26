function solution(id_list, report, k) {
    const history = {};
    const processed = new Set();
    const count = {};
    
    id_list.forEach((id) => {
        history[id] = [];
        count[id] = 0;
    });
    
    report.forEach((query) => {
        if (!processed.has(query)) {
            processed.add(query);
            const [user, reported] = query.split(' ');
            history[user].push(reported);
            count[reported]++;
        }
    })
    
    return id_list.map((user) => history[user].filter((reported) => count[reported] >= k).length);
}