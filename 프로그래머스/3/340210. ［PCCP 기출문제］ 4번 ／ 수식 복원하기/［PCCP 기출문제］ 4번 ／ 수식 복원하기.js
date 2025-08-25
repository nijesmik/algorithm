function solution(expressions) {
    const o = [];
    const x = [];
    
    expressions.forEach((exp) => {
        const splited = exp.split(" ");

        if (splited[4] === 'X') {
            x.push(splited);
            return;
        }
        
        if (splited[1] === '-') {
            const ans = splited[4];
            splited[4] = splited[0];
            splited[0] = ans;
            splited[1] = '+';
        }
        
        o.push(splited);
    })
    
    let base = 0;
    let candidate = 2;
    
    o.forEach((exp) => {
        const [num1, _, num2, __, num3] = exp;
        
        let k = num3.length - 1;
        for (let i = num1.length - 1, j = num2.length - 1; i >= 0 && j >= 0; i--, j--) {
            const a = Number(num1[i]);
            const b = Number(num2[j]);
            const c = Number(num3[k]);

            if (a + b > c) {
                base = a + b - c;
            } else {
                candidate = Math.max(candidate, a + 1, b + 1, c + 1);
            }
            
            k--;
        }
    })
    
    const updateCandidate = (num) => {
        for (let c of num) {
            candidate = Math.max(candidate, Number(c) + 1);
        }
    }
    
    x.forEach((exp) => exp.filter((_, i) => i % 2 == 0 && i < 4).forEach(updateCandidate))
    
    if (base != 0) {
        base = Math.max(base, candidate);
    } else if (candidate === 9) {
        base = 9;
    }
    
    return x.map((exp) => {
        const [num1, sign, num2] = exp;
        const s = sign === '+' ? 1 : -1;
        
        if (base != 0) {
            exp[4] = (parseInt(num1, base) + parseInt(num2, base) * s).toString(base);
            return exp.join(" ");
        }
        
        for (let i = num1.length - 1, j = num2.length - 1; i >= 0 && j >= 0; i--, j--) {
            const a = Number(num1[i]);
            const b = Number(num2[j]);
            const isPossible = s > 0 ? a + b < candidate : a - b >= 0;
            if (!isPossible) {
                exp[4] = '?';
                return exp.join(" ");
            }
        }
        
        exp[4] = (parseInt(num1) + parseInt(num2) * s).toString();
        return exp.join(" ");
    });
}