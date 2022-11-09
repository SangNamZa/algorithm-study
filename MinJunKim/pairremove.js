function solution(s)
{
    var answer = -1;
    console.log(s)
    function removeSame(s) {
    for (let i = 0; i < s.length; i++) {
      if (s[i] === s[i + 1]) {
        s.splice(i, 2);
      }
    }
    removeSame(s)
    console.log(s)
  }

    return answer;
}
