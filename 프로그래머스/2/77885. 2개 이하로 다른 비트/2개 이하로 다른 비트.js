const MAX_LENGTH = Math.pow(10, 15).toString(2).length;

function solution(numbers) {
    return numbers
        .map((num) => [...num.toString(2).padStart(MAX_LENGTH, '0')])
        .map((num) => {
            for (let i = MAX_LENGTH - 1; i >= 0; i--) {
                if (num[i] === '0') {
                    num[i] = '1';
                    break;
                } else if (num[i] === '1' && i > 0 && num[i - 1] === '0') {
                    num[i] = '0';
                    num[i - 1] = '1';
                    break;
                }
            }
            return parseInt(num.join(''), 2);
        })
}