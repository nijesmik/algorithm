function solution(targets) {
    targets.sort(([as, ae], [bs, be]) => {
        if (as === bs) {
            return ae - be;
        }
        return as - bs;
    })
   
    let missile = 1;
    
    targets.reduce(([ms, me], [ts, te]) => {
        if (ms < te && ts < me) {
            return [Math.max(ts, ms), Math.min(te, me)];
        }
        missile++;
        return [ts, te];
    })
    
    return missile;
}