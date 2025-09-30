function solution(numbers) {
    return 45 - numbers.reduce((sum, num) => sum + num);
}