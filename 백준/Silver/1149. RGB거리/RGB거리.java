import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] home = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                home[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][3]; // dp[i][j] = i 번째 집을 j색으로 칠했을 때의 최소 비용

        dp[0][0] = home[0][0];
        dp[0][1] = home[0][1];
        dp[0][2] = home[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + home[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + home[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + home[i][2];
        }
        int minCost = Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
        System.out.println(minCost);
    }
}
