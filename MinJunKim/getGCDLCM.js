function solution(arr) {
    var answer = 0;
    function gcd(a,b){
        while(b>0){
            let temp = b
            b = a%b
            a = temp
        }
        return a
    }
    
    return arr.reduce((a,b)=>
        (a*b)/ gcd(a,b)
    )
}
