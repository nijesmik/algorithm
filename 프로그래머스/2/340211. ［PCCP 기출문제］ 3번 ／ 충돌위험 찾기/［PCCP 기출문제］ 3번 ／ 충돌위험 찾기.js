let answer = 0;
const map = new Map();

const check = () => {
    for (const [key, {cnt}] of map) {
        if (cnt > 1) {
            answer++;
        }
    }
    map.clear();
};

const increaseCount = (r, c) => {
    const key = r * 1000 + c;
    if (!map.has(key)) {
        map.set(key, {cnt: 0});
    }
    const val = map.get(key);
    val.cnt++;
}

const move2 = (cur, target, idx) => {
    if (cur[idx] < target[idx]) {
        cur[idx]++;
        return;
    }
    cur[idx]--;
}

const move = (cur, target) => {
    if (cur[0] !== target[0]) {
        move2(cur, target, 0);
    } else {
        move2(cur, target, 1);    
    }
    increaseCount(...cur);
}

function solution(points, routes) {
    const targetIdx = Array.from({length: routes.length}).fill(1)
    
    const currentPos = routes.map((route)=>{
        const startIdx = route[0] - 1;
        const [startR, startC] = points[startIdx];
        increaseCount(startR, startC);
        return [startR, startC]
    })
    check();
    
    const l = routes[0].length;
    while (targetIdx.some((Idx)=> Idx < l)) {
        currentPos.forEach((pos, i)=> {
            const tIdx = targetIdx[i];
            if (tIdx >= l) {
                return;
            }
            const pIdx = routes[i][tIdx] - 1;
            const targetPos = points[pIdx];
            move(pos, targetPos);
            if (pos[0] === targetPos[0] && pos[1] === targetPos[1]) {
                targetIdx[i]++;
            }
        })
        check();
    }


    return answer;
}