function solution(s) {
    var answer = [];
    let ArrayPass = []
    ArrayPass.push(s[0])
    answer.push(-1)
    for(let i = 1; i<s.length;i++){
      if(ArrayPass.includes(s[i])){
          let indexofExist = ArrayPass.findIndex(e=>e===s[i])
          let orderDif = i - indexofExist
       
          answer.push(orderDif)
          ArrayPass[indexofExist]=''
          // console.log(ArrayPass)
          ArrayPass.push(s[i])
          // console.log(ArrayPass)

          // ArrayPass.findIndex(e=>e===s[i])
          // (i-위의값)이거를 answer에 푸시
          // ArrayPass에 속한 그 위치를 구한값을 ArrayPass 에서 빼고서 s[i]를 새로 푸시
          
      }
      else{ArrayPass.push(s[i]); answer.push(-1)}
    }
    // console.log(ArrayPass)
    return answer;
}
