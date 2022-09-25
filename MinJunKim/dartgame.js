//어디서 에러나는지 모르겟음
function solution(dartResult) {
  let answerArray = [];
  let tempNum = 0;
  for (let i = 0; i < dartResult.length; i++) {
    if (dartResult[i] >= 0 && dartResult < 10) {
      if (dartResult[i] === 1 && dartResult[i + 1] === 0) {
        tempNum = 10;
        i++;
      }
        else {tempNum = dartResult[i]}
}
      //숫자가 아닌경우들
    else if (dartResult[i] === 'S') {
      answerArray.push(Math.pow(tempNum, 1));
    } else if (dartResult[i] === 'D') {
      answerArray.push(Math.pow(tempNum, 2));
    } else if (dartResult[i] === 'T') {
      answerArray.push(Math.pow(tempNum, 3));
    } else if (dartResult[i] === '*') {
      answerArray[answerArray.length - 1] *= 2;
      answerArray[answerArray.length - 2] *= 2;
    } else if (dartResult[i] === '#') {
      answerArray[answerArray.length-1] *= -1    }
  }
  // answerArray.push(tempNum);

  console.log(answerArray);
  // return answer;
}
