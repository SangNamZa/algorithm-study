function solution(seoul) {
  let answer = '';
  let place = 0;
  for (let i = 0; i < seoul.length; i++) {
    if ((seoul[i] === 'Kim')) {
      place = i;
    }
  }
  answer = '김서방은 ' + place + '에 있다';
  return answer;
}
