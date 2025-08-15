const getDay = (date) => {
    const [y, m, d] = date.split('.').map(Number);
    return y * 28 * 12 + m * 28 + d;
}

function solution(today, terms, privacies) {
    const termMap = new Map(terms.map((term) => {
        const [name, period] = term.split(' ');
        return [name, parseInt(period)];
    }));
    
    return privacies.reduce((answer, privacy, index) => {
        const [date, term] = privacy.split(' ');
        const limit = getDay(date) + termMap.get(term) * 28 - 1;
        if (getDay(today) > limit) {
            answer.push(index + 1);
        }
        return answer;
    }, []);
}