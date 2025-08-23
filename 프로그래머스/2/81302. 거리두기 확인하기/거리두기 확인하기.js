const checkPlace = (place) => {
    const P = [];
    for (let i = 0; i < place.length; i++) {
        for (let j = 0; j < place[0].length; j++) {
            if (place[i][j] === 'P') {
                P.push([i, j]);
            }
        }
    }
    
    const validateDistance = ({r1, c1, r2, c2}) => {
        if (r1 === r2) {
            for (let j = c1 + 1; j < c2; j++) {
                if (place[r1][j] === 'X') {
                    return true;
                }
            }
            return false;
        }
        
        if (c1 === c2) {
            for (let i = r1 + 1; i < r2; i++) {
                if (place[i][c1] === 'X') {
                    return true;
                }
            }
            return false;
        }
        
        const delta = c1 < c2 ? 1 : -1;
        return (place[r1 + 1][c1] === 'X' && place[r1][c1 + delta] === 'X');
    }
    
    for (let i = 0; i < P.length; i++) {
        const [r1, c1] = P[i];
        for (let j = i + 1; j < P.length; j++) {
            const [r2, c2] = P[j];
            const dist = Math.abs(r2 - r1) + Math.abs(c2 - c1);
            if (dist <= 2 && !validateDistance({r1, c1, r2, c2})) {
                return 0;
            }
        }
    }
    return 1;
}

function solution(places) {
    return places.map((place) => checkPlace(place.map((row) => row.split(''))));
}