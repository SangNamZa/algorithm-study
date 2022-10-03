효율성 테스트에서 틀림

function solution(s) {
  var answer = true;
  s = s.split('');

  function earase() {
    
      for (let i = 0; i < s.length; i++) {
        if (s[i] === '(' && s[i + 1] === ')') {
          s.splice(i, 2);
          earase();
        }
      }
    
  }
  earase();
  if (s.length !== 0) {
    answer = false;
  } 
  return answer;
}
