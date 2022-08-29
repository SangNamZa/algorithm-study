function solution(numbers, hand) {
  let result = '';
  const keypad = {
    1: [0, 3],
    2: [1, 3],
    3: [2, 3],
    4: [0, 2],
    5: [1, 2],
    6: [2, 2],
    7: [0, 1],
    8: [1, 1],
    9: [2, 1],
    '*': [0, 0],
    0: [1, 0],
    '#': [2, 0],
  };
  //거리 구하는 함수
  function locationLength(x, y) {
    let xLoc =
      keypad[x][0] - keypad[y][0] > 0
        ? keypad[x][0] - keypad[y][0]
        : -(keypad[x][0] - keypad[y][0]);
    let yLoc =
      keypad[x][1] - keypad[y][1] > 0
        ? keypad[x][1] - keypad[y][1]
        : -keypad[x][1] - keypad[y][1];
    return xLoc + yLoc;
  }

  for (let i = 0; i < numbers.length; i++) {
    let leftHandLoc = '*';
    let rightHandLoc = '#';
    if (numbers[i] === 1 || numbers[i] === 4 || numbers[i] === 7) {
      result += 'L';
      leftHandLoc === numbers[i];
    }
    if (numbers[i] === 3 || numbers[i] === 6 || numbers[i] === 9) {
      result += 'R';
      rightHandLoc === numbers[i];
    }
    if (
      numbers[i] === 2 ||
      numbers[i] === 5 ||
      numbers[i] === 8 ||
      numbers[i] === 0
    ) {
      //각손 위치에서 numbers[i]까지의 거리를 구하기
      if (
        locationLength(numbers[i], leftHandLoc) <
        locationLength(numbers[i], rightHandLoc)
      ) {
        result += 'L';
      } else if (
        locationLength(numbers[i], leftHandLoc) >
        locationLength(numbers[i], rightHandLoc)
      ) {
        result += 'R';
      } else if (
        locationLength(numbers[i], leftHandLoc) ===
          locationLength(numbers[i], rightHandLoc) &&
        hand === 'right'
      ) {
        result += 'R';
      } else if (
        locationLength(numbers[i], leftHandLoc) ===
          locationLength(numbers[i], rightHandLoc) &&
        hand === 'left'
      ) {
        result += 'L';
      }
    }
  }
  return result;
  // console.log(result);
}
