// 효율성 테스트에서 탈락...

function solution(n) {
    var answer = 0
    function countOne(m){
        let ones = 0
        for(let j = 0; j<m.length + 1; j++){
            if(m[j]==='1'){ones+=1}
        }
        return ones
    }
    for(let i = 1; i <1000000; i++){
        let nTwo = n.toString(2)
        let numTwo = (n+i).toString(2)
        if (countOne(nTwo)===countOne(numTwo)){
        answer = numTwo
        break}
    }
    answer = Number(answer)
    answer = parseInt(answer,2)

return answer;
}
