function solution(arr)
{
    var answer = [];
    answer.push(arr[0])
    for(let i = 1; i<arr.length; i++){
       if(answer.includes(arr[i],answer.length-1)!==true){answer.push(arr[i])}
    }

    
    return answer;
}
