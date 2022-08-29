/*
147은 왼손
369는 오른손
2580은 가까운 손이
거리가 같다면 주손으로
 */

public class PushKeypad {
    public static void main(String[] args) {
        PushKeypad pushKeypad = new PushKeypad();
        String right = pushKeypad.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right");
        System.out.println(right);
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[] left = new int[]{0, 3};
        int[] right = new int[]{2, 3};
        for (int number : numbers) {
            int[] position = getPosition(number);
            if (number%3 == 1) { // 147
                answer.append("L");
                left = position;
            } else if (number%3 == 0 && number != 0) { // 369
                answer.append("R");
                right = position;
            } else { // 2580
                int leftDistance = getDistance(position, left);
                int rightDistance = getDistance(position, right);
                if (leftDistance < rightDistance) { // 왼손이 가까울때
                    answer.append("L");
                    left = position;
                } else if (leftDistance > rightDistance) { // 오른손이 가까울때
                    answer.append("R");
                    right = position;
                } else { // 거리가 같을때
                    if (hand.equals("left")) { // 왼손잡이
                        answer.append("L");
                        left = position;
                    } else { // 오른손잡이
                        answer.append("R");
                        right = position;
                    }
                }
            }
        }
        return answer.toString();
    }

    private int[] getPosition(int number) {
        if (number == 0) {
            return new int[]{1, 3};
        }
        return new int[]{(number-1)%3, (number-1)/3};
    }

    private int getDistance(int[] position, int[] hand) {
        return Math.abs(position[0]-hand[0]) + Math.abs(position[1]-hand[1]);
    }
}
