function solution(food) {
    let answer = []
    let result = ''
    let Array = [0]
    for(let i = 1; i<food.length; i++){
        Array.push(Math.floor(food[i]/2))
    }
    // [ 0, 3, 0, 1 ] 각 음식이 몇개씩 가능한지 배열(맨 앞 0은 index 맞추는 용)

    for(let i =1; i<Array.length; i++){
        if(Array[i]!==0){
            for(let j= 0; j<Array[i];j++){
                answer.push(i)
            }
        }
    } //answer = [1,1,1,3] : 각 인덱스의 값만큼 인덱스를 더함 0이 아닌거만
    answer.push(0)
    for(let i = 0; i<answer.length; i++){
        result = result + answer[i]
    }
    for(let i = 2; i<answer.length+1; i++){
        result = result + answer[answer.length-i]
    }
    console.log(answer)
    return result;
}
