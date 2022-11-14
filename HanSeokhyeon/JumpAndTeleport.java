public class JumpAndTeleport {
    public static void main(String[] args) {
        JumpAndTeleport jumpAndTeleport = new JumpAndTeleport();
        int solution = jumpAndTeleport.solution(5000);
        System.out.println("solution = " + solution);
    }

    public int solution(int n) {
        int ans = 1;
        if (n == 1) {
            return 1;
        }

        while (true) {
            if (n % 2 == 1) {
                n--;
                ans++;
            }
            n/=2;
            if (n == 1) {
                return ans;
            }
        }
    }
}
