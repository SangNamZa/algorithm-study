function solution(n) {
  var answer = 0;
  
  let xArray = [];

  for (let i = 1; i < n; i++) {
    if (n % i == 1) {
      xArray.push(i);
    }
  }
   answer = Math.min(...xArray);

  return answer;
}
