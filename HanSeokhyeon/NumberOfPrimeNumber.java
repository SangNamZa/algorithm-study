public class NumberOfPrimeNumber {

    public static void main(String[] args) {
        NumberOfPrimeNumber numberOfPrimeNumber = new NumberOfPrimeNumber();
        int solution = numberOfPrimeNumber.solution(437674, 3);
//        int solution = numberOfPrimeNumber.solution(110011, 10);
//        int solution = numberOfPrimeNumber.solution(885733, 3);
        System.out.println("solution = " + solution);
    }

    public int solution(int n, int k) {
        String kBase = getKBase(n, k); // k진수로 변환 -> 2110020101011
        String[] targetNumbers = kBase.split("0"); // ["211", "", "2", "1", "1", "11"]

        int answer = 0;
        for (String targetNumber : targetNumbers) {
            if ("".equals(targetNumber)) continue;
            answer += isPrimeNumber(Long.parseLong(targetNumber)); // 소수면 +1 아니면 +0
        }
        return answer;
    }

    private int isPrimeNumber(long targetNumber) {
        if (targetNumber == 1) { // 1은 소수가 아님
            return 0;
        }
        for (int i = 2; i <= Math.pow(targetNumber, 0.5); i++) { // 제곱근까지만 계산하면 됨
            if (targetNumber % i == 0) { // 나눠지면 소수가 아님
                return 0;
            }
        }
        return 1; // 소수이므로 +1
    }

    private String getKBase(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n >= 1) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }


}
