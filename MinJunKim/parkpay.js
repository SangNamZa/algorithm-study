조금 차이로 틀렷는데 알만한데 고치기 힘들어서 놔둠....


function solution(fees, records) {
  var answer = [];
  let recordsArray = [];
  records.forEach((element) => {
    recordsArray.push(element.split(' '));
  });
  // [['05:34', '5951', 'IN'], [그다음]] 이런식으로 각 배열로 쪼갰음
  //각 시간을 분값으로 통일
  // IN이면 -시간값, OUT이면 +시간값
  //낮은 차부터 번호별로 계산해서 푸쉬

  for (let i = 0; i < recordsArray.length; i++) {
    recordsArray[i][0] = recordsArray[i][0].split(':');
    recordsArray[i][0] =
      Number(recordsArray[i][0][0] * 60) + Number(recordsArray[i][0][1]);
  }
  // [[ '42059', '0148', 'IN' ],, [그다음]] 이런식으로 시간을 바꿧음
  //각 시간을 분값으로 통일

  for (let i = 0; i < recordsArray.length; i++) {
    if (recordsArray[i][2] === 'IN') {
      recordsArray[i][0] = -recordsArray[i][0];
    } else {
      recordsArray[i][0] = +recordsArray[i][0];
    }
  }
  // IN이면 -시간값, OUT이면 +시간값으로 만들엇음 [ -132059, '5961', 'IN' ] 이런식으로

  let carNumArray = [];
  for (let i = 0; i < recordsArray.length; i++) {
    {
      carNumArray.push([recordsArray[i][1], recordsArray[i][0]]);
    }
  }
  //[ '5961', -30034 ], [ '0000', -36000 ], 이런식으로 번호별 시간 정리햇음
  console.log(carNumArray);

  for (let i = 0; i < recordsArray.length; i++) {
    for (let j = 0; j < recordsArray.length; j++) {
      if (carNumArray[i][0] === carNumArray[j][0] && i < j) {
        carNumArray[i][1] = carNumArray[i][1] + carNumArray[j][1];
        carNumArray[j][1] = 0;
      }
    }
  }
  carNumArray.sort();
  // [ '0000', -1105 ],
  // [ '0000', 0 ],
  // [ '0000', 0 ],
  // [ '0148', 0 ],
  // [ '0148', 670 ],
  // [ '5961', 0 ],
  // [ '5961', 0 ],
  // [ '5961', 0 ],
  // [ '5961', 146 ] 이 상태까지 왓음
  let almostAnswer = [];

  for (let i = 0; i < recordsArray.length; i++) {
    if (carNumArray[i][1] < 0) {
      carNumArray[i][1] = carNumArray[i][1] + 24 * 60 - 1;
    }
    if (carNumArray[i][1] !== 0) {
      almostAnswer.push(carNumArray[i]);
    }
  }
  console.log(almostAnswer);
  // [ [ '0000', 334 ], [ '0148', 670 ], [ '5961', 146 ] ] 여기까지 왓드아아아아
  function pay(time) {
    if (time < fees[0]) {
      return fees[1];
    } else {
      return fees[1] + Math.ceil((time - fees[0]) / fees[2]) * fees[3];
    }
  }
  for (let i = 0; i < almostAnswer.length; i++) {
    answer.push(pay(almostAnswer[i][1]));
  }
  console.log(answer);
  return answer;
}
