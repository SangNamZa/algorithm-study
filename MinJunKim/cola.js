function solution(a, b, n) {
    var answer = 0;
    let get = 0
    let keep = 0
    // n/a*b는 받는개수=get,answer+get, n%a 나머지는 킵=keep,
    // temp<a 면 스톱
    function trade(a,b,n){
         let get = Math.floor(n/a)*b
         console.log(get)
         let keep = n%a
         answer += get
        // console.log(answer)
        get = get+keep
        keep = 0
         if(get<a || b>=a){return answer}
        else if(get>=a){
             trade(a,b,get)
         }
    }
    trade(a,b,n)
   
    console.log(answer)
    return answer;
}
