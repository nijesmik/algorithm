const TYPES = [
    ['R', 'T'],
    ['C', 'F'],
    ['J', 'M'],
    ['A', 'N'],
];

function solution(survey, choices) {
    const scores = TYPES.reduce((scores, [t1, t2]) => {
        scores[t1] = 0;
        scores[t2] = 0;
        return scores;
    }, {})
    
    survey.forEach((type, index) => {
        const score = choices[index] - 4;
        const [t1, t2] = type.split('');
        scores[t1] -= score;
        scores[t2] += score;
    })
    
    return TYPES.map(([t1, t2]) => {
        if (scores[t1] >= 0) {
            return t1;
        }
        return t2;
    }).join('');
}