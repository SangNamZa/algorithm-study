public class MaxAndMin {

    public static void main(String[] args) {
        MaxAndMin maxAndMin = new MaxAndMin();
        String solution = maxAndMin.solution("1 2 3 4");
        System.out.println("solution = " + solution);
    }

    public String solution(String s) {
        String[] stringNumbers = s.split(" ");
        long max = Long.MIN_VALUE; long min = Long.MAX_VALUE;
        for (String str : stringNumbers) {
            long i = Long.parseLong(str);
            max = Math.max(i, max);
            min = Math.min(i, min);
        }

        return String.format("%d %d", min, max);
    }
}
