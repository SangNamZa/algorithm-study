function solution(progresses, speeds) {
    // 7 3 9
    // 5 10 1 1 20 1
    // 차례로 보면서 이전꺼보다 오래걸리는 수(큰수)가 나오는지 체크
    // 더 큰 수가 나오면 push, 작은수면 최근값(마지막값) +1
    let timeArray = []
    for(let i = 0; i<progresses.length; i++){
    timeArray.push(Math.ceil((100-progresses[i])/speeds[i]))
    }
    // console.log(timeArray[timeArray.length-1])
    let answer = [1]
    for(let i = 1; i<timeArray.length; i++){
        if(timeArray[i]>timeArray[i-1]){answer.push(1)}
    else {answer[answer.length-1]=answer[answer.length-1] + 1}} 
    // 5 10 1 2 20 1 이럴 경우를 반영 못했네...
    return answer;
}
