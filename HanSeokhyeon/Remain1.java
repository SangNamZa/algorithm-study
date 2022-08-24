/*
n을 x로 나눌 때 1이 남는 제일 작은 수 구하기
for문 돌면서 나누다가 1남으면 끝
 */

public class Remain1 {
    public static void main(String[] args) {
        Remain1 remain1 = new Remain1();
        int solution = remain1.solution(12);
        System.out.println(solution);
    }

    public int solution(int n) {
        int i;
        for (i = 1; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }
        return i;
    }
}
