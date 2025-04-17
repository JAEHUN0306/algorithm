import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] stones = new int[n];

        for (int i = 0; i < n; i++) {
            stones[i] = sc.nextInt();
        }

        long[] dp = new long[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long force = (long)(j - i) * (1 + Math.abs((long)stones[i] - stones[j]));
                long maxForce = Math.max(dp[i], force);

                dp[j] = Math.min(dp[j], maxForce);
            }
        }

        System.out.println(dp[n-1]);
    }
}