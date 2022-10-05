/*
이진 변환 반복하기

1. 0 제거
2. 길이구하기
3. 이진수로 변환
 */

import java.util.Arrays;

public class RepeatBinaryTransformation {
    public static void main(String[] args) {
        RepeatBinaryTransformation repeatBinaryTransformation = new RepeatBinaryTransformation();
        int[] solution = repeatBinaryTransformation.solution("110010101001");
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public int[] solution(String s) {
        int count = 0; int zeros = 0;
        while (!"1".equals(s)) { // "1"이 아니면 계속 돌기
            int length = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') { // 1이면 length를 더하고
                    length++;
                } else { // 0이면 zeros를 더한다.
                    zeros++;
                }
            }
            s = getBinary(length); // 바이너리 변환
            count++;
        }
        return new int[]{count, zeros};
    }

    private String getBinary(int modular) {
        String binary = "";
        while (modular > 0) {
            binary = String.format("%d%s", modular % 2, binary); // 나머지를 s 앞에 붙이기
            modular = modular / 2; // 몫을 업데이트
        }
        return binary;
    }
}
