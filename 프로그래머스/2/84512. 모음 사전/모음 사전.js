function solution(word) {
    const vowels = ['A', 'E', 'I', 'O', 'U']
    
    const isAnswer = (alphabets) => {
        if (alphabets.length !== word.length) {
            return false;
        }
        const candidate = alphabets.join('');
        return candidate === word;
    }
    
    let answer = 0;
    let endFlag = false;
    
    const dfs = (depth = 0, alphabets = []) => {
        if (endFlag || depth > 5) {
            return;
        } else if (isAnswer(alphabets)) {
            endFlag = true;
            return;
        }
        
        answer++;
        for (let v of vowels) {
            alphabets.push(v);
            dfs(depth + 1, alphabets);
            alphabets.pop(v);
        }
    }
    
    dfs();
    
    return answer;
}