function solution(s) {
    var answer = [];
    let group = s.replace("{{","").replace("}}","").split("},{")
    let groupArray = []
    for(let i = 0; i<group.length; i++){
    groupArray.push(group[i].split(','))}
    groupArray.sort((a, b)=>{return a.length - b.length})
    //여기까지는 가능
    console.log(setList);
  // 첫 번째 요소 answer에 저장
  answer.push(parseInt(setList[0][0]));
  // 각 배열의 요소중에 answer에 없는 요소를 찾고 answer에 저장
  for (let i = 1; i < setList.length; i++) {
    let ele = getEle(setList[i], answer);
    answer.push(ele);
  }

  return answer;
}
function getEle(set, answer) {
  //set과 answer의 모든 요소를 배교해서 answer에 없는 set요소를 찾기
  for (let i = 0; i < set.length; i++) {
    for (let j = 0; j < answer.length; j++) {
      set = set.filter((ele) => ele !== answer[j]);
    }
  }
  return parseInt(set[0]);
    //javascript filter를 몰랐음
    
    
    return answer;
}
