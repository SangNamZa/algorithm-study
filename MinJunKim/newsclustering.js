function solution(str1, str2) {
    const alphabet = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',]
    let answer = 0
    // str1 split, 2 split
    // i length 만큼 i,i+1을 push
    // A + B 에서 A-교집합+B를 하면 합집합
    str1 = str1.toLowerCase()
    str2 = str2.toLowerCase()
    let A = str1.split('')
    let B = str2.split('')
    let arrayA = []
    let arrayB = []
    for(let i = 0; i<A.length-1;i++){
        if(alphabet.includes(A[i]) && alphabet.includes(A[i+1])){arrayA.push(A[i]+A[i+1])}
    }
    for(let i = 0; i<B.length-1;i++){
        if(alphabet.includes(B[i]) && alphabet.includes(B[i+1])){arrayB.push(B[i]+B[i+1])}
    }
    if(arrayA.length==0 && arrayB.length==0){ answer = 65536; return answer}
    
    let count = 0
    for(let i =0; i<arrayA.length;i++){
        for(let j= 0; j<arrayB.length;j++){
            if (arrayA[i]===arrayB[j]){count++}
        }
    }
    answer = Math.floor(count / (arrayA.length+arrayB.length-count) * 65536)
    return answer    
    console.log(answer)
    
}
