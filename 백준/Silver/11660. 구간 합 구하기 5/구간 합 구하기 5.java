import java.util.Scanner;

public class Main {
    /*
    N×N개의 수가 N×N 크기의 표에 채워져 있다. (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성하시오. (x, y)는 x행 y열을 의미한다.

    예를 들어, N = 4이고, 표가 아래와 같이 채워져 있는 경우를 살펴보자.
    1	2	3	4   00 01 02 03  1 3 6 10
    2	3	4	5   10 11 12 13  3 8 << -> D[i][j]가 있으면, D[2][2]를 구하려면 = D[2][1] + D[1][2] - D[1][1] + A[2][2]
    3	4	5	6   20 21 22 23  6   D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j]
    4	5	6	7   30 31 32 33  10  D[X2][Y2] - D[X2][Y1-1] - D[X1-1][Y2] + D[X1-1][Y1-1]
    여기서 (2, 2)부터 (3, 4)까지 합을 구하면 3+4+5+4+5+6 = 27이고, (4, 4)부터 (4, 4)까지 합을 구하면 7이다.

    표에 채워져 있는 수와 합을 구하는 연산이 주어졌을 때, 이를 처리하는 프로그램을 작성하시오.

    입력
    첫째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다. (1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000) 둘째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다. 다음 M개의 줄에는 네 개의 정수 x1, y1, x2, y2 가 주어지며, (x1, y1)부터 (x2, y2)의 합을 구해 출력해야 한다. 표에 채워져 있는 수는 1,000보다 작거나 같은 자연수이다. (x1 ≤ x2, y1 ≤ y2)

    출력
    총 M줄에 걸쳐 (x1, y1)부터 (x2, y2)까지 합을 구해 출력한다.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 원본 배열 입력 받기
        int[][] nums = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        // 구간 합 배열 계산
        int[][] sums = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sums[i][j] = sums[i][j-1] + sums[i-1][j] - sums[i-1][j-1] + nums[i][j];
            }
        }

        // 질의 처리
        for (int i = 0; i < m; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int result = sums[x2][y2] - sums[x2][y1-1] - sums[x1-1][y2] + sums[x1-1][y1-1];
            System.out.println(result);
        }
    }
}
