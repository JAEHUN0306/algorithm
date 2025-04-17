import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();

            if(n == 1) {
                System.out.println(1);
                continue;
            }
            if(n == 2) {
                System.out.println(2);
                continue;
            }
            if(n == 3) {
                System.out.println(4);
                continue;
            }

            int[] dp = new int[n + 1]; // dp[i] = i까지 만드는데 가능한 가짓 수
            dp[1] = 1; // 1
            dp[2] = 2; // 1 + 1, 2
            dp[3] = 4; // 1 + 1 + 1, 1 + 2, 2 + 1, 3
            for (int j = 4; j <= n; j++) {
                dp[j] = dp[j - 3] + dp[j - 2] + dp[j - 1];
            }

            System.out.println(dp[n]);
        }

    }
}
