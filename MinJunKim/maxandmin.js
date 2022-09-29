function solution(s) {
    var answer = '';

    let answerArr = s.split(' ')
      answerArr.sort(function(a,b){return a-b})
 
answer = `${answerArr[0]} ${answerArr[answerArr.length-1]}`
    console.log(answer)
    return answer;
}
