/*
N개의 최소공배수

최소공배수 = 두수의 곱 / 최대공약수
앞에서부터 두 수씩 계속 최소공배수를 구해가면 된다.
 */

public class LeastCommonMultiple {
    public static void main(String[] args) {
        LeastCommonMultiple leastCommonMultiple = new LeastCommonMultiple();
//        int solution = leastCommonMultiple.solution(new int[]{2,6,8,14});
//        int solution = leastCommonMultiple.solution(new int[]{1,2,3});
        int solution = leastCommonMultiple.solution(new int[]{2, 4, 6, 8});
        System.out.println("solution = " + solution);
    }

    public int solution(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int gcd = getGcd(result, arr[i]);
            result = result * arr[i] / gcd;
        }
        return result;
    }

    private int getGcd(int a, int b) {
        for (int i = a * b / 2; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
