import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            long[] dp = new long[n + 1];

            // 초기값 설정
            if (n >= 1) dp[1] = 1;
            if (n >= 2) dp[2] = 1;
            if (n >= 3) dp[3] = 1;

            for (int j = 4; j <= n; j++) {
                dp[j] = dp[j - 3] + dp[j - 2];
            }

            System.out.println(dp[n]);
        }
    }
}
