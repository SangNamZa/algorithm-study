/*
약수의 개수와 덧셈

left ~ rigth 수중
약수의 개수가
    짝수면 더하고
    홀수면 뺀다
 */

public class NumberOfDivisorAndAddition {
    public static void main(String[] args) {
        NumberOfDivisorAndAddition numberOfDivisorAndAddition = new NumberOfDivisorAndAddition();
        int solution = numberOfDivisorAndAddition.solution(13, 17);
        System.out.println("solution = " + solution);
    }

    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) { // left ~ right
            int n = getNumberOfDivisor(i); // 약수의 개수 구하기
            if (n % 2 == 0) { // 짝수
                answer += i;
            } else { // 홀수
                answer -= i;
            }
        }
        return answer;
    }

    private int getNumberOfDivisor(int number) {
        int result = 1; // number
        for (int i = 1; i < number/2+1; i++) { // 2 ~ number의 절반 + 1
            if (number % i == 0) { // 약수
                result += 1;
            }
        }
        return result;
    }
}
