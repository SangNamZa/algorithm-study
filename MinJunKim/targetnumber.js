내가 푼거 아님
재귀가 되도록 구성을 해야할 듯 하였는데, dfs 문제인지 아직 모르는 수준...

function solution(numbers, target) {
    let answer = 0;
    
    dfs(0, 0);
    
    function dfs(index, sum) {
        if(index === numbers.length) {
            if (sum === target) {
                answer++;
             }
            return;
        }
        
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }
    
    return answer;
}
