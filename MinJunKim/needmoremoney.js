function solution(price, money, count) {
    var answer = -1;
answer = (price + price*count)*count/2 -money 
    return answer > 0 ? answer : 0;
}
