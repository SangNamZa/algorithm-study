function solution(n) {
    let pArray = []
   for ( let i = 0; i<=n; i++){
       if( i === 0){pArray.push(0)}
       else if ( i === 1 ){pArray.push(1)}
       else {
           pArray.push((pArray[i-1]+ pArray[i-2] ) % 1234567)
       }
   }
   let answer = pArray[n] 
    return answer
}
