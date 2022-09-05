let nums = [1, 2, 7, 6, 4];
function solution(nums) {
  var answer = 0;
  function isSosu(num) {
    if (num === 1) {
      return false;
    } else if (num === 2) {
      return true;
    } else {
      for (let i = 2; i < num; i++) {
        if (num % i === 0) {
          return false;
        }
      }
      return true;
    }
  }

  function sums(i, j, k) {
    let sumNum = nums[i] + nums[j] + nums[k];
    return sumNum;
  }
  let array = [];

  for (let i = 0; i < nums.length - 2; i++) {
    for (let j = i + 1; j < nums.length - 1; j++) {
      for (let k = j + 1; k < nums.length; k++) {
        array.push(sums(i, j, k));
      }
    }
  }

  for (let i = 0; i < array.length; i++) {
    if (isSosu(array[i])) {
      answer += 1;
    }
  }

  console.log(answer);
  return answer;
}

solution(nums);
