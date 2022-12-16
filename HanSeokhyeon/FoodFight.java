public class FoodFight {
    public static void main(String[] args) {
        FoodFight foodFight = new FoodFight();
//        String solution = foodFight.solution(new int[]{1, 3, 4, 6});
        String solution = foodFight.solution(new int[]{1, 7, 1, 2});
        System.out.println("solution = " + solution);
    }

    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        int foodNumber = 1;
        for (int i = 1; i < food.length; i++) {
            int nowFood = getNowFood(food[i]);
            for (int j = 0; j < nowFood; j++) {
                answer.append(foodNumber);
            }
            foodNumber++;
        }

        return answer + "0" + getReversedAnswer(answer.toString());
    }

    private String getReversedAnswer(String answer) {
        StringBuilder sb = new StringBuilder(answer);
        return sb.reverse().toString();
    }

    private int getNowFood(int food) {
        int nowFood = food;
        if (nowFood % 2 == 1) {
            nowFood--;
        }
        nowFood /= 2;
        return nowFood;
    }
}

