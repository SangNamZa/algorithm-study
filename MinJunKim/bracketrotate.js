function solution(s) {
    let answer = s.length/2;
    //stack 활용하기
    //맞는 괄호 세트 수 만큼 리턴?
    //차례로 돌다가 '()', '[]', '{}' 이 잇으면 빼기 : 남은게 잇으면 result 0, 최대 length/2 에서 스킵하면 -1씩...
    for(let i = 0; i < s.length; i++){
        if(s[i]+s[i+1]==='()'||'[]'||'{}'){s.split('').splice(i,2)}
    }
    console.log(s)
    return answer;
}
