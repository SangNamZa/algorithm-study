/*
피보나치 수
 */

public class Pibonaci {

    public static void main(String[] args) {
        Pibonaci pibonaci = new Pibonaci();
        int solution = pibonaci.solution(100000);
        System.out.println("solution = " + solution);
    }

    public int solution(int n) {
        return pibonaci(n);
    }

    private int pibonaci(int n) {
        int[] pibo = new int[100001];
        pibo[0] = 0;
        pibo[1] = 1;
        for (int i = 2; i <= n; i++) {
            pibo[i] = (pibo[i-1] + pibo[i-2]) % 1234567;
        }
        return pibo[n];
    }
}
