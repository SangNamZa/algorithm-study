function solution(s) {
  var answer = [];
  let a = 0;
  let b = 0;
  let tempNum = 0;
  while (s > 1) {
    a++;
    for (let i = 0; i < s.length; i++) {
      if (s[i] === '1') {
        tempNum++;
      }
    }
    b = b + (s.length - tempNum);
    s = tempNum.toString(2);
    tempNum = 0;
  }
  answer.push(a);
  answer.push(b);
  console.log(answer);
  return answer;
}
