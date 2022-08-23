/* 최소직사각형
완전탐색
현재 가로 세로 최댓값을 가지고 하나씩 탐색하면서
늘리는 양(가로+세로)이 더 적은 경우로 해서 추가
*/

public class MinimumRectangle {
    public static void main(String[] args) {
        MinimumRectangle minimumRectangle = new MinimumRectangle();
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(minimumRectangle.solution(sizes));
    }

    public int solution(int[][] sizes) {
        int width = sizes[0][0];
        int height = sizes[0][1];
        for (int[] size : sizes) {
            if ((width >= size[0] && height >= size[1]) || (width >= size[1] && height >= size[0])) {
                continue;
            }
            int diff1 = 0;
            if (width - size[0] < 0) {
                diff1 += width - size[0];
            }
            if (height - size[1] < 0) {
                diff1 += height - size[1];
            }
            int diff2 = 0;
            if (width - size[1] < 0) {
                diff2 += width - size[1];
            }
            if (height - size[0] < 0) {
                diff2 += height - size[0];
            }

            if (diff1 >= diff2) {
                if (width < size[0]) {
                    width = size[0];
                }
                if (height < size[1]) {
                    height = size[1];
                }
            } else {
                if (width < size[1]) {
                    width = size[1];
                }
                if (height < size[0]) {
                    height = size[0];
                }
            }
        }
        return width * height;
    }
}
