function solution(id_list, report, k) {
  // 1. report의 중복을 없앤다. new Set
  // 2.[[reporting_id,reported_id],[reporting_id,reported_id],...] 이런식으로 정리한다
  // 3.각 배열에서 reported_id 숫자 카운팅 : id_list에서 돌아가면서 reported_id와 같으면 카운트
  // 4.각 값이 k이상이면, 그게 속한것의 reporting_id 값 카운트업
  // 5.id_list 차례로 카운트업 된거 반영
  var answer = [];
  let noRepeatReport = [...new Set(report)]; //중복 사라진 report 배열
  let changedFormNoRepeatReportArray = [];
  noRepeatReport.forEach((item) => {
    let changedFormNoRepeatReport = item.split(' ');
    changedFormNoRepeatReportArray.push(changedFormNoRepeatReport);
  });
  // changedFormNoRepeatReportArray : [[reporting_id,reported_id],[reporting_id,reported_id],...] 이런 상태임
  let id_listSetZero = [];
  for (let i = 0; i < id_list.length; i++) {
    id_listSetZero.push(0);
  }
  // id-list 차례대로 다 0 셋팅,
  for (let i = 0; i < changedFormNoRepeatReportArray.length; i++) {
    for (let j = 0; j < id_list.length; j++) {
      if (id_list[j] == changedFormNoRepeatReportArray[i][1]) {
        id_listSetZero[j] += 1;
      }
    }
  }
  // id_list 차례로 몇번 리포트 당했는지 숫자가 할당 됨.

  //정지되는 아이디는 k 이상인것
  let overKid = [];
  for (let i = 0; i < id_list.length; i++) {
    if (id_listSetZero[i] > k - 1) {
      overKid.push(id_list[i]);
    }
  }
  // overKid 는 정지당할 아이디 리스트

  let getEmailList = [];
  for (let i = 0; i < overKid.length; i++) {
    for (let j = 0; j < id_list.length; j++) {
      if (overKid[i] == changedFormNoRepeatReportArray[j][1]) {
        getEmailList.push(changedFormNoRepeatReportArray[j][0]);
      }
    }
  }

  let getEmailNum = [];
  for (let i = 0; i < id_list.length; i++) {
    getEmailNum.push(0);
  }

  for (let i = 0; i < id_list.length; i++) {
    for (let j = 0; j < getEmailList.length; j++) {
      if (id_list[i] === getEmailList[j]) {
        getEmailNum[i] += 1;
      }
    }
  }
  answer = getEmailNum;
  // console.log(answer);
  return answer;
}
