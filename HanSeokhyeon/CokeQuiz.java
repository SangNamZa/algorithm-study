/*
콜라 문제

testcase

2, 1, 8
8 -> 4
4 -> 2
2 -> 1
1
7개

3, 1, 8
8 -> 2 + 2
4 -> 1 + 1
2 -> 0
3개

3, 2, 8
8 -> 2 * 2 + 2
6 -> 2 * 2
4 -> 1 * 2 + 1
3 -> 1 * 2
2
12개
 */

public class CokeQuiz {

    public static void main(String[] args) {
        CokeQuiz cokeQuiz = new CokeQuiz();
//        int solution = cokeQuiz.solution(2, 1, 20);
        int solution = cokeQuiz.solution(3, 2, 8);
        System.out.println("solution = " + solution);
    }

    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {
            int divider = n / a; // 몫
            int remain = n % a; // 나머지
            int bonus = divider * b; // 몫 * b가 새로 받은거
            answer += bonus; // 받은 보너스 추가
            n = bonus + remain; // 다음 회차 콜라 수 = 보너스 + 남은거
        }
        return answer;
    }
}
