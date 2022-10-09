function solution(n) {
  let answer = 0;
  //홀수인 약수만 됨
  for(let i = 0; i <= n; i++) {
  	if(n%i === 0 && i%2 === 1) answer++;
  }
  
  return answer;
}
