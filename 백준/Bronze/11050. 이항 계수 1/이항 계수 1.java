import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        문제
        자연수
        \(N\)과 정수
        \(K\)가 주어졌을 때 이항 계수
        \(\binom{N}{K}\)를 구하는 프로그램을 작성하시오.

        입력
        첫째 줄에
        \(N\)과
        \(K\)가 주어진다. (1 ≤
        \(N\) ≤ 10, 0 ≤
        \(K\) ≤
        \(N\))

        출력

        \(\binom{N}{K}\)를 출력한다.
         */

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        long result = 1;

        for (int i = 0; i < K; i++) {
            result *= N - i;
        }

        for (int i = 0; i < K; i++) {
            result /= K - i;
        }

        System.out.println(result);

    }
}
