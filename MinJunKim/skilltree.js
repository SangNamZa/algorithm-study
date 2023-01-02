function solution(skill, skill_trees) {
    var answer = 0;
    // C의 위치값 구하고, temp값을 다음꺼 업뎃, 비교, 없으면 통과하려햇음
    let arr = []
    for(let i = 0; i<skill_trees.length; i++){
        for(let j = 0; j<skill.length;j++){
            arr.push(skill_trees[i].indexOf(skill[j]))
        }
        // 각 인덱스값들로 배열을 만들었고, 없는값은 -1로 인덱스값 처리됨. 근데 조건 중에서 먼저 선행해야만 하는 경우를 빼먹고 진행하였음
        let filterArr = arr.filter(num =>num!==-1)
        let sortArr = arr.filter(num =>num!==-1).sort()
        console.log(arr)
        console.log(filterArr)
        console.log(sortArr)
        if(filterArr == sortArr){console.log('answer')}

        arr = []
        console.log(arr)
    }
    return answer;
}
