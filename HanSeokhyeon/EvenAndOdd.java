public class EvenAndOdd {
    public static void main(String[] args) {
        EvenAndOdd evenAndOdd = new EvenAndOdd();
        String solution = evenAndOdd.solution(3);
        System.out.println("solution = " + solution);
    }

    public String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }
}
