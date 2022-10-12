// for 문으로 조건 하나하나 하다가 꼬이고, for문 너무 많은거에서 

function solution(n, words) {
    var answer = [];
    let wrongPlace = 0
    for(let i = 0; i < words.length; i++){
        for(let j = 0; j < words.length; j++){
            if(words[i]===words[j] && i < j){wrongPlace = j+1
                                   break}
        }
    }
    for(let i = 0; i < words.length; i++){if(words[i][words[i].length]!==words[i+1][0]){console.log('hi')}}
    console.log(wrongPlace % n)
    answer.push(wrongPlace%n)
    return answer;
}
