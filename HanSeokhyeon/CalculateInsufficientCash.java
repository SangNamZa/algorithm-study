/*
N번째 이용하면 금액이 N배 되는 놀이기구
 */

public class CalculateInsufficientCash {
    public static void main(String[] args) {
        CalculateInsufficientCash calculateInsufficientCash = new CalculateInsufficientCash();
        long solution = calculateInsufficientCash.solution(3, 20, 4);
        System.out.println(solution);
    }

    public long solution(int price, int money, int count) {
        long sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += (long) price * i;
        }

        long result = sum - money;
        if (result < 0) {
            result = 0;
        }
        return result;
    }
}
