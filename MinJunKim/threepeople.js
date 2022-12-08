function solution(number) {
    var answer = 0;
    // 배열에서 3개를 고르는 방법, i<j<k / 삼중 for문 오바 아닌가...
//     for(let i = 0; i<number.length; i++){
//         for(let j=0; j<number.length;j++){
//             for(let k=0; k<number.length; k++){
//                 while(i<j<k){
//                     if(number[i]+number[j]+number[k]==0){
//                         answer++
//                     }
//                 }
//             }
//         }
//     }
   function getCombination(elements, pick) {
    // 기저사례: 골라야 하는 길이가 1이면 각 원소가 조합이 된다.
    if(pick === 1) return elements.map(elem => [elem]);
    
    const combinations = [];
    // 각 원소에 남은 원소로 만들 수 있는 조합들을 붙인다.
    elements.forEach((element, index) => {
        // 만약 남은 원소의 길이가 골라야 하는 길이보다 짧으면 빈 배열이 반환되기 때문에 조합이 생성되지 않는다.
        const smallerCombinations = getCombination(elements.slice(index + 1), pick - 1);
        smallerCombinations.forEach(combination => {
            combinations.push([element].concat(combination));
        });
    });
    return combinations;
}
    const combinationArray = getCombination(number,3)
    console.log(getCombination(number,3))
    for(let i=0; i<combinationArray.length; i++){
        if(combinationArray[i][0]+combinationArray[i][1]+combinationArray[i][2]==0){answer++}
    }
    return answer;
}
