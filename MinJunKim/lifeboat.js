
// 젤 작은거 젤 큰거부터 따져서 한도 초과면 젤큰거 뺴고 진행, 답은 1증가
// 젤큰거 작은거가 한도 안넘으면 두개 뺴고 다음것들 진행, 답 1증가
// 개수 한개 남으면 답 1증가
function solution(people, limit) {
  var answer = 0;
  let peopleOrder = people.sort((a,b) => a-b);
  let i = 0;
  let j = people.length - 1;
  while (i < j) {
    if (peopleOrder[i] + peopleOrder[j] > limit) {
      j--;
    } else {
      i++;
      j--;
      
    }
      answer++;
  }
  if (i === j) {
    answer++;
  }
  return answer;
}
