import java.util.Arrays;

public class MakeMinimum {

    public static void main(String[] args) {
        MakeMinimum makeMinimum = new MakeMinimum();
        int solution = makeMinimum.solution(new int[]{1, 4, 2}, new int[]{5, 4, 4});
        System.out.println("solution = " + solution);
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            answer += A[i]*B[B.length-i-1];
        }
        return answer;
    }
}
