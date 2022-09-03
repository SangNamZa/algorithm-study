function solution(n) {
  let answer = 0;
  let changedToThreeArray = [];
  let x = 0;
  function toThree() {
    if (n >= 3) {
      x = n % 3;
      n = (n - x) / 3;
      changedToThreeArray.push(x);
      toThree(n);
    } else {
      changedToThreeArray.push(n);
    }
  }
  toThree(n);
  // changedToThreeArray : [ 0, 0, 2, 1 ]
  let sum = 0;
  let y = changedToThreeArray.length;
  for (let i = 0; i < changedToThreeArray.length; i++) {
    sum = sum + changedToThreeArray[i] * 3 ** (y - i - 1);
  }

  answer = sum;
  return answer;
  // console.log(answer);
}
