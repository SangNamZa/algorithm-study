let N = 5;
let stages = [2, 1, 2, 6, 2, 4, 3, 3];

function solution(N, stages) {
  let stageDifficultArr = [];
  // for i 돌면서 실패율 배열에 실패율을 넣음, 실패율 큰값부터 index값을 result에 넣음
  // i번째 : 전체-i+1 / i 포함 개수 :Ai
  // i+1 : 전체 - i포함개수 :A  / i+1 포함 개수 :B = Ai+1
  let peopleOnStage = peopleOnStage - stages.filter((e) => 'i' === e).length;
  for (let i = 1; i < stages.length + 1; i++) {
    stageDifficultArr.push(
      stages.filter((e) => 'i' === e).length / stages.length
    );
  }
  console.log(stageDifficultArr);
  return answer;
}
solution(N, stages);
