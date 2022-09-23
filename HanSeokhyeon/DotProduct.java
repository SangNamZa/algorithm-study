/*
내적
 */

public class DotProduct {
    public static void main(String[] args) {
        DotProduct dotProduct = new DotProduct();
        int solution = dotProduct.solution(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2});
        System.out.println("solution = " + solution);
    }

    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i]*b[i];
        }
        return answer;
    }
}
