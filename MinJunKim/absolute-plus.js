function solution(absolutes, signs) {
  let answer = 0;
  let sumPlus = 0;
  let sumMinus = 0;

  for (let i = 0; i < absolutes.length; i++) {
    sumPlus = sumPlus + absolutes[i];

    if (signs[i] === false) {
      sumMinus = sumMinus + absolutes[i] * -2;
    }
  }
  answer = sumPlus + sumMinus;


  return answer;
}
