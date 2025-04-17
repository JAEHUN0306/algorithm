import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][2]; // dp[i][0] -> i 번째 계단에 한 칸 올라와서 도착했을 떄의 최대 점수
        // dp[i][1] -> i 번째 계단에 두 칸 올라와서 도착했을 떄의 최대 점수. -> dp[i-2][0] , dp[i-2][1] + score[i]

        dp[1][0] = score[1];
        dp[1][1] = 0; // 두칸 올라온건 불가능

        if(n >= 2) {
            dp[2][0] = score[1] + score[2];
            dp[2][1] = score[2];
        }

        for(int i = 3; i <= n; i++) {
            dp[i][0] = dp[i - 1][1] + score[i];

            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + score[i];
        }

        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }
}
