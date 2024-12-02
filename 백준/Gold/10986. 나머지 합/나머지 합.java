import java.util.Scanner;

public class Main {
    
    /*
    문제
    수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
    
    즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.
    
    입력
    첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)
    
    둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 109)
    
    출력
    첫째 줄에 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 출력한다.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 합 배열의 모듈러 연산 결과를 저장할 배열
        long[] count = new long[M];
        long sum = 0;

        // 구간 합의 나머지가 같은 인덱스의 개수 카운트
        for (int i = 0; i < N; i++) {
            sum = (sum + sc.nextInt()) % M;
            count[(int)sum]++;
        }

        // 나머지가 0인 경우를 더함
        long result = count[0];

        // 같은 나머지를 가진 구간의 쌍을 계산
        for (int i = 0; i < M; i++) {
            result += (count[i] * (count[i] - 1)) / 2;
        }

        System.out.println(result);
    }
}
