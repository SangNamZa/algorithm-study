function solution(survey, choices) {
  let answer = 'RCJA';
  //초이스 별로 카운트하는 케이스들 정해두기, 각 유형별로 0점으로 시작해서 점수 업뎃, 각각 비교해서 선택
  let R = 0;
  let T = 0;
  let C = 0;
  let F = 0;
  let J = 0;
  let M = 0;
  let A = 0;
  let N = 0;

  for (let i = 0; i < survey.length; i++) {
    switch (choices[i]) {
      case 7:
        survey[i].split('')[0] += 3;
        break;
      case 6:
        survey[i].split('')[0] += 2;
        break;
      case 5:
        survey[i].split('')[0] += 1;
        // 이 값은 A 이긴한데 string이고 위에 A는 number 라서 연동이 안됨.
        break;
      case 4:
        break;
      case 3:
        survey[i].split('')[1] += 1;
        break;
      case 2:
        survey[i].split('')[1] += 2;
        break;
      case 1:
        survey[i].split('')[1] += 3;
        break;
    }
    console.log(typeof survey[i].split('')[0]);
  }

  //각 지표별로 A와N 값을 비교해서 A>=N 이면 A를 아니면 N을
  // console.log(A);
  return answer;
}

solution(survey, choices);
