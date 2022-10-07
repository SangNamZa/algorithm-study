function solution(new_id) {
  new_id = new_id.toLowerCase(); // 1단계
  new_id = new_id.split('');
  let stringNum = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];

  function stepTwo(id) {
    for (let i = 0; i < id.length; i++) {
      if (
        stringNum.includes(id[i]) === false &&
        id[i].toLowerCase() === id[i].toUpperCase() &&
        id[i] !== '-' &&
        id[i] !== '_' &&
        id[i] !== '.'
      ) {
        id.splice(i, 1);
        stepTwo(id);
      }
    }
  }
  stepTwo(new_id); // 2단계
  console.log(new_id);

  function stepThree() {
    for (let i = 0; i < new_id.length; i++) {
      if (new_id[i] === '.' && new_id[i + 1] === '.') {
        new_id.splice(i, 1);
        stepThree();
      }
    }
  }
  stepThree(); //3단계

  if (new_id[0] === '.') {
    new_id.splice(0, 1);
  }
  if (new_id[new_id.length - 1] === '.') {
    new_id.splice(new_id.length - 1, 1);
  } //4단계

  if (new_id.length === 0) {
    new_id.push('a');
  } // 5단계

  if (new_id.length >= 15) {
    new_id.splice(15, new_id.length - 15);
  }
  if (new_id[14] === '.') {
    new_id.splice(14, 1);
  } //6단계

  function stepSeven(id) {
    while (id.length < 3) {
      id.push(id[id.length - 1]);
    }
  }
  stepSeven(new_id);

  // console.log(new_id.join(''));
  return new_id.join('');
}
