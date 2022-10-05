function solution(lottos, win_nums) {
    var answer = [];
    let maxScore = 0
    let zeroNum = 0
    let minScore = 0
    for(let i = 0; i < lottos.length; i++){
        if(win_nums.includes(lottos[i])){minScore++}
        if(lottos[i]===0){zeroNum++}
    }
    maxScore = minScore + zeroNum
    console.log(minScore)
    function rank(n){
        if(n===6){return 1}
        if(n===5){return 2}
        if(n===4){return 3}
        if(n===3){return 4}
        if(n===2){return 5}
        else {return 6}
    }
    answer.push(rank(maxScore))
    answer.push(rank(minScore))
    return answer;
}
