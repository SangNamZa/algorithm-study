function solution(nums) {
  var answer = 0;
  let answerArray = [...new Set(nums)];
  let CanGetMax = nums.length / 2;
  answer = answerArray.length > CanGetMax ? CanGetMax : answerArray.length;
  return answer;
}
