function solution(numbers) {
    return numbers
        .map((num) => ['0', ...num.toString(2)])
        .map((num) => {
            for (let i = num.length - 1; i >= 0; i--) {
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