function solution(k, tangerine) {
    var answer = 0;
    // tangerine을 차례로하고, 차례로 가져감, 개수가 차면 스톱, 그때의 가지수, tangerine두번째부터 또 진행...
    tangerine.sort((a,b)=>a-b)
    // i 번째부터 k개 뽑고, i+1번째부터 k개... 쭉 비교...
    console.log(tangerine)
    let tempArr = []
    let ansArr = []
    for(let i=0; i<tangerine.length - k+1; i++){
       // tempArr.push(tangerine[i])
       //  tempArr.push(tangerine[i+1])
       //  tempArr.push(tangerine[i+k-2])
       //  tempArr.push(tangerine[i+k-1])
        for(let j = i; j<i+k; j++){
            tempArr.push(tangerine[j])
            console.log('hi')
        }
        console.log(tempArr)
        let set = new Set(tempArr)
        let uniqueArr = [...set]
        console.log(uniqueArr, 'unique')
        ansArr.push(uniqueArr.length)
        tempArr = []
        // tempArr 중복제거 후 개수 구해서 answer 최소로 업데이트
    }
    const minValue = Math.min.apply(null, ansArr);
answer = minValue
    return answer;
}
    
