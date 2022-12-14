//test case 1개가 시간초과로 뜸. //친부분들은 다른거가 틀리고 1번 테스트는 맞음

function solution(n, k) {
    var answer = -1;
    let arr = []
    //n을 k진수로 바꾸기
    //0인 지점으로 쪼개기
    //각각 소수인지 판별하기
    n=n.toString(k)
    n=n.toString()
    n=n.split('0') //[ '211', '2', '1', '1', '11' ]
    // function isPrime(m){
    //     if(m==1){return false}
    //     if(m==2){return true}
    //     if(m==3){return true}
    //    for(let i =2; i<m; i++){
    //        if(m%i===0){return false}
    //        return true
    //    }
    // }
    function isPrime(num) {
        if(num===1){return false}
        if(num===2){return true}
            for(let i = 2; i<num; i++) {
                if(num % i === 0) { 
                    return false;
                }
            }
        return num > 1;
    }
    
    for(let i =0; i<n.length; i++){
        if(isPrime(n[i])===true){arr.push(n[i])}
    }
    
    
    answer = arr.length
    console.log(n)
    return answer;
}
