function solution(record) {
    var answer = [];
    let arr = []
   
    for(let i = 0; i<record.length; i++){
       arr.push(record[i].split(' '))
    } // 우선 배열 쪼갬
//     arr = 	[
//   [ 'Enter', 'uid1234', 'Muzi' ],
//   [ 'Enter', 'uid4567', 'Prodo' ],
//   [ 'Leave', 'uid1234' ],
//   [ 'Enter', 'uid1234', 'Prodo' ],
//   [ 'Change', 'uid4567', 'Ryan' ]
// ]
    
    
    
     let idName = {} // {uid1234: Muzi, uid4567: Ryan} 이런식이길
    for(let i =0; i<record.length;i++){
        if(arr[i][2]!==undefined){idName[arr[i][1]]=arr[i][2]}
    }
    // idName = { uid1234: 'Prodo', uid4567: 'Ryan' }
    
    
    
    for(let i = 0; i<record.length;i++){
            if(arr[i][0]==='Enter'){
                let uid = arr[i][1]  //uid1234
                 // console.log(idName[uid]) // Prodo Ryan Prodo Prodo
                answer.push(`${idName[uid]}님이 들어왔습니다.`)
               
            } else if(arr[i][0]==='Leave'){
                let uid = arr[i][1] 
                answer.push(`${idName[uid]}님이 나갔습니다.`)
            }
        
    }
    
//     	[
//   'uid1234님이 들어왔습니다.',
//   'uid4567님이 들어왔습니다.',
//   'uid1234님이 나갔습니다.',
//   'uid1234님이 들어왔습니다.'
// ] 고유 아이디의 최종 값을 구해서 대체하면됨
   
    console.log(answer)
    return answer
}
