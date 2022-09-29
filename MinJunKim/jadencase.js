function solution(s) {
    let answer = s[0].toUpperCase()
    for(let i =1;i<s.length;i++){
    // s[i]
    let chr = s[i].toLowerCase()
    if(s[i-1]===" "||0){
        chr = s[i].toUpperCase()
    }
        answer = answer + chr
    }
    return answer
}
