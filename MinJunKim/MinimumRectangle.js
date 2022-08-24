function solution(sizes) {
  for (let i = 0; i < sizes.length; i++) {
    if (sizes[i][0] > sizes[i][1]) {
      let swapNum = sizes[i][1];
      sizes[i][1] = sizes[i][0];
      sizes[i][0] = swapNum;
    }
  }
  let w = sizes.map((size) => size[0]);
  let h = sizes.map((size) => size[1]);
  const maxW = Math.max(...w);
  const maxH = Math.max(...h);
  let answer = maxW * maxH;
  return answer;
}
