function solution(numbers) {
    var answer = [];
    for(let i=0; i<numbers.length; i++){
        for(let j = 0; j<numbers.length; j++){
            let plusNum = numbers[i] +numbers[j];
    if(answer.includes(plusNum)===false&& i!==j){answer.push(plusNum)}
    }}
    answer.sort(function(a,b){return a-b})
    console.log(answer)
    return answer;
}
