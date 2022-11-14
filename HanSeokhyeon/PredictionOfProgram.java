public class PredictionOfProgram {
    public static void main(String[] args) {
        PredictionOfProgram predictionOfProgram = new PredictionOfProgram();
        int solution = predictionOfProgram.solution(8, 4, 7);
        System.out.println("solution = " + solution);
    }

    public int solution(int n, int a, int b) {
        int count = 1;

        while (true) {
            if (b-a == 1 && b%2==0 && a%2==1) {
                return count;
            } else if (a-b == 1 && a%2==0 && b%2==1) {
                return count;
            }
            a = (a+1)/2;
            b = (b+1)/2;
            count++;
        }
    }
}
