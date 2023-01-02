function solution(skill, skill_trees) {
    var answer = 0;
    // C의 위치값 구하고, temp값을 다음꺼 업뎃, 비교, 없으면 통과
    let arr = []
    for(let i = 0; i<skill_trees.length; i++){
        for(let j = 0; j<skill.length;j++){
            arr.push(skill_trees[i].indexOf(skill[j])===-1 ? 100 : skill_trees[i].indexOf(skill[j]))
            //스킬트리에 사용이 안되었을경우 100으로 취급함
        }
        let filterArr = arr.filter(num =>num!==-1)
        let sortArr = arr.filter(num =>num!==-1).sort((a,b)=>{return a-b})
        console.log(JSON.stringify(filterArr))
        console.log(JSON.stringify(sortArr))
        //JSON.stringify로 배열값이 같은지 비교 가능하게함
        
        if(JSON.stringify(filterArr)===JSON.stringify(sortArr)){answer++}

        arr = []
        console.log(arr)
    }
    return answer;
}
