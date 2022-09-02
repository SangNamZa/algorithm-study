/*
3진법 뒤집기
10진수 -> 3진수 -> 뒤집기 -> 10진수
 */

public class ReverseTernary {
    public static void main(String[] args) {
        ReverseTernary reverseTernary = new ReverseTernary();
        int solution = reverseTernary.solution(45);
        System.out.println(solution);
    }

    public int solution(int n) {
        String ternary = getReversedTernary(n); // 10진수 -> 뒤집어진 3진수
        return getDecimal(ternary); // 뒤집어진 3진수 -> 10진수
    }

    private String getReversedTernary(int n) {
        StringBuilder result = new StringBuilder();
        while (n >= 3) {
            result.append(n % 3); // 나머지 추가
            n /= 3;
        }
        result.append(n); // 남은 몫 추가
        return result.toString();
    }

    private int getDecimal(String ternary) {
        int result = 0;
        for (int i = 0; i < ternary.length(); i++) {
            int digit = Character.getNumericValue(ternary.charAt(ternary.length()-1-i)); // 1의 자리수 부터
            result += digit * Math.pow(3, i); // 3의 i승을 곱하기
        }
        return result;
    }
}
