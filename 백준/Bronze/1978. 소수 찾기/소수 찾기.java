import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        문제
        주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

        입력
        첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

        출력
        주어진 수들 중 소수의 개수를 출력한다.

        - 1은 소수가 아니므로 먼저 체크합니다.
        - 2는 유일한 짝수 소수이므로 별도로 처리합니다.
        - 짝수는 2를 제외하고 모두 소수가 아니므로 먼저 걸러냅니다.
        - 3부터 num의 제곱근까지만 확인합니다. 이는 연산 횟수를 크게 줄여줍니다.
        - 홀수만 확인하므로 `i += 2`를 사용합니다.
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            boolean isPrime = true;

            if (num <= 1) {
                isPrime = false;
            } else if (num == 2) {
                isPrime = true;
            } else if (num % 2 == 0) {
                isPrime = false;
            } else {
                for (int j = 3; j <= Math.sqrt(num); j += 2) {
                    if (num % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                count++;
            }
        }
        System.out.println(count);
    }
}
