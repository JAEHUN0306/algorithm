import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // n이 1이나 2인 경우 바로 결과 반환
        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n == 2) {
            System.out.println(3);
            return;
        }
        
        // 2 x n 타일을 1 x 2 , 2 x 1타일로 채우는 경우의 수
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 3;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-2] * 2 + dp[i-1]) % 10007;
        }
        
        System.out.println(dp[n]);
    }
}