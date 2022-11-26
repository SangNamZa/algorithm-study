/*
멀리뛰기
a[1] = 1
a[2] = 2
a[3] = 3
a[4] = 5
a[5] = 8
11111 2111 1211 1121 1112 221 212 122
 */

public class TheLongJump {

    public static void main(String[] args) {
        TheLongJump theLongJump = new TheLongJump();
        long solution = theLongJump.solution(5);
        System.out.println("solution = " + solution);
    }

    public long solution(int n) {
        long[] answers = new long[n+1];
        answers[0] = 1;
        answers[1] = 1;
        for (int i = 2; i < n+1; i++) {
            answers[i] = (answers[i-1] + answers[i-2]) % 1234567;
        }
        return answers[n];
    }
}
