public class NextBiggerNumber {

    public static void main(String[] args) {
        NextBiggerNumber nextBiggerNumber = new NextBiggerNumber();
        int solution = nextBiggerNumber.solution(78);
        System.out.println("solution = " + solution);
    }

    public int solution(int n) {
        int binaryNOneCount = getOneCount(n); // 1수
        for (int i = n+1;; i++) {
            if (binaryNOneCount == getOneCount(i)) { // n의 1수와 i의 1수의 비교
                return i;
            }
        }
    }

    private int getOneCount(int n) {
        String binaryN = Integer.toBinaryString(n); // binary로 변환
        int count = 0;
        for (int i = 0; i < binaryN.length(); i++) {
            if (binaryN.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
