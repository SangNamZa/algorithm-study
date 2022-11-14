/*
H-index

65310
6 0 -> 0
5 1 -> 1
3 2 -> 2
1 3 -> 1
0 4 -> 0

631
6 0 -> 0
3 1 -> 1
1 2 -> 1
 */

import java.util.Arrays;

public class H_Index {

    public static void main(String[] args) {
        H_Index h_index = new H_Index();
//        int solution = h_index.solution(new int[]{3, 0, 6, 1, 5});
        int solution = h_index.solution(new int[]{6, 3, 1});
        System.out.println("solution = " + solution);
    }

    public int solution(int[] citations) {
        int answer = 0;
        citations = Arrays.stream(citations).sorted().toArray();
        for (int i = 0; i < citations.length; i++) {
            answer = Math.max(answer, Math.min(i+1, citations[citations.length-(i+1)]));
        }
        return answer;
    }
}
