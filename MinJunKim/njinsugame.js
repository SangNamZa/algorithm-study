function solution(n, t, m, p) {
    var answer = '';
    // 0, 1 n진법, 2n진법 ... m명이면 m이하 숫자를 n진법으로 모두 push
    let arrAll = [] // 숫자들을 차례로 진수에 맞추어 변형하고
    let arrAns = [] // 변형된 숫자들을 쭉 이어서 담음
    for(let i =0; i<t*m ; i++){
        arrAll.push(i.toString(n).split(''))
    }
    for(let i=0; i<arrAll.length; i++){
        for(let j=0; j<arrAll[i].length;j++){
            arrAns.push(arrAll[i][j])
        }
    }
    console.log(arrAns)
//     [
//   '0', '1', '1', '0', '1', '1',
//   '1', '0', '0', '1', '0', '1',
//   '1', '1', '0', '1', '1', '1',
//   '1', '0', '0', '0', '1', '0',
//   '0', '1'
// ]
    let shoutArr=[]
    //m명 t번째까지만 돌림
   if(m!==p){ for(let i=0; i<t*m;i++){
        if((i+1)%m===p){
            answer = answer+arrAns[i]
        } 
    }}
    //나머지가 0으로 되는경우(m=p이면 따로 구함)
    if(m===p)
        { for(let i=0; i<t*m;i++){
        if((i+1)%m===0){
            answer = answer+arrAns[i]
        } 
    }
    }
    // answer = 02468ACE11111111 : 대문자로...
    answer = answer.toUpperCase()
    return answer;
}
