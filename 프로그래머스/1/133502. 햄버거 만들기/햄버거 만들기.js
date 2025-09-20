function solution(ingredient) {
    let stack = [];
    let burger = 0;
    
    const canMake = () => stack.length >= 4
          && stack[stack.length - 1] === 1
          && stack[stack.length - 2] === 3
          && stack[stack.length - 3] === 2
          && stack[stack.length - 4] === 1;
    
    const make = () => {
        for (let i = 0; i < 4; i++) {
            stack.pop();
        }
        burger++;
    }
    
    ingredient.forEach((x) => {
        stack.push(x);
        if (canMake()) {
            make();
        }
    })
    
    return burger;
}