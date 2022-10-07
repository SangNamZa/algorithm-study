/*
숫자의 표현

10
1234

11
56
 */

public class ExpressionOfNumber {
    public static void main(String[] args) {
        ExpressionOfNumber expressionOfNumber = new ExpressionOfNumber();
        int solution = expressionOfNumber.solution(11);
        System.out.println("solution = " + solution);
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; sum < n; j++) {
                sum += j;
            }
            if (sum == n) {
                answer++;
            }
        }
        return answer;
    }
}
