function solution(left, right) {
  var answer = 0;
  //n의 약수 개수 구하는 함수

  function yaksuNum(n) {
    let count = 0;
    for (let i = 1; i < n + 1; i++) {
      if (n % i === 0) {
        count += 1;
      }
    }
    if (count % 2 === 0) {
      return n;
    } else return -n;
  }
  for (let i = left; i < right + 1; i++) {
    answer = answer + yaksuNum(i);
  }
  return answer;
}
