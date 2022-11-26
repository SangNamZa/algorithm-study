/*
n^2 배열 자르기

경우가 2가지

1. 한줄만 존재하는 경우
xxx
x23
xxx

2. 여러줄에 걸쳐서 존재하는 경우
xx3
223
3xx
 */

import java.util.Arrays;

public class CutArray {

    int[] array;
    int n;
    long left;
    long right;

    public static void main(String[] args) {
        CutArray cutArray = new CutArray();
//        int[] solution = cutArray.solution(2, 0, 0);
        int[] solution = cutArray.solution(3, 2, 5);
//        int[] solution = cutArray.solution(4, 7, 14);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public int[] solution(int n, long left, long right) {
        init(n, left, right);

        int leftX = (int) (left % n);
        int leftY = (int) (left / n);
        int rightX = (int) (right % n);
        int rightY = (int) (right / n);

        if (rightY == leftY) { // y가 같다는건 한줄이라는 의미
            useOneLine(leftX, rightX + 1, leftY); // 한줄
        } else {
            useOneLine(leftX, n, leftY); // 첫번째줄
            useCenterLine(leftY, rightY); // 중간줄
            useOneLine(0, rightX + 1, rightY); // 마지막줄
        }

        return array;
    }

    private void init(int n, long left, long right) {
        this.array = new int[(int) (right - left + 1)];
        this.n = n;
        this.left = left;
        this.right = right;
    }

    private void useOneLine(int leftX, int rightX, int leftY) {
        for (int j = leftX; j < rightX; j++) {
            int index = (int) (leftY * n + j - left);
            if (leftY > j) {
                array[index] = leftY + 1;
            } else {
                array[index] = j + 1;
            }
        }
    }

    private void useCenterLine(int leftY, int rightY) {
        for (int i = leftY + 1; i < rightY; i++) {
            for (int j = 0; j < n; j++) {
                int index = (int) (i * n + j - left);
                if (i > j) {
                    array[index] = i + 1;
                } else {
                    array[index] = j + 1;
                }
            }
        }
    }
}
