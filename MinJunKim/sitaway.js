answer array 만들면 0이었던 값이 1로 바뀌는게 해결이 안됨


// (i,j)이것과(i+1,j)(i,j+1)(i+1,j+1)을 비교한다
// i,j 는 0부터3까지
// i,j가 P일때 (i+1,j)(i,j+1)에 P가 있으면 0 false
// i,j가 P일때 (i+1,j+1)에 P일떄 (i+1,j)(i,j+1)모두가 X인게 아니면면 false, 나머지는 true


function solution(places) {
  var answer = [0, 0, 0, 0, 0];
  // places[0],places[1]... 일때 answer.push(1) 하는 함수 짜기

  //한 교실 값 구하는 함수
  let oneRoom = [];
  function oneRoomAnswer(r) {
    for (let i = 0; i < 5; i++) {
      oneRoom.push(places[r][i].split(''));
    }
    // console.log(oneRoom);
    for (let i = 0; i < 4; i++) {
      for (let j = 0; j < 4; j++) {
        if (oneRoom[i][j] === 'P' && oneRoom[i][j + 1] === 'P') {
          return 0;
        } else if (oneRoom[i][j] === 'P' && oneRoom[i + 1][j] === 'P') {
          return 0;
        } else if (
          oneRoom[i][j] === 'P' &&
          oneRoom[i + 1][j + 1] === 'P' &&
          oneRoom[i + 1][j] !== 'X'
        ) {
          return 0;
        } else if (
          oneRoom[i][j] === 'P' &&
          oneRoom[i + 1][j + 1] === 'P' &&
          oneRoom[i][j + 1] !== 'X'
        ) {
          return 0;
        } else if (oneRoom[4][3] === 'P' && oneRoom[4][4] === 'P') {
          return 0;
        } else if (oneRoom[3][4] === 'P' && oneRoom[4][4] === 'P') {
          return 0;
        } else {
          return 1;
        }
      }
    }
  }
  // for (let i = 0; i < 5; i++) {
  //   oneRoomAnswer(i);
  // }
  // answer.push(oneRoomAnswer(0));
  // answer[0] = oneRoomAnswer(0);
  answer[1] = oneRoomAnswer(1);
  // answer[2] = oneRoomAnswer(2);
  // answer[3] = oneRoomAnswer(3);
  // answer[4] = oneRoomAnswer(4);

  console.log(answer);
  return answer;
}

solution(places);
