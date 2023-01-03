function solution(t, p) {
    var answer = 0;
    let temp = ''
    for(let i = 0; i<t.length-p.length+1; i++){
        for(let j= 0; j<p.length; j++){
            temp = temp + t[i+j]
        }
        console.log(temp)
        if(temp<=p){answer++}
        temp = ''

    }
    return answer;
}
