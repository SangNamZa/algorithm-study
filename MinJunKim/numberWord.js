function solution(s) {
  var answer = 0;
  // let v = s.replace('one', '1');
  v = s
    .replaceAll('one', '1')
    .replaceAll('two', '2')
    .replaceAll('three', '3')
    .replaceAll('four', '4')
    .replaceAll('five', '5')
    .replaceAll('six', '6')
    .replaceAll('seven', '7')
    .replaceAll('eight', '8')
    .replaceAll('nine', '9')
    .replaceAll('zero', '0');
answer = Number(v)
  return answer;
}