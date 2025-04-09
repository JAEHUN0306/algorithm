import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 학생 수
        int K = sc.nextInt(); // 방 최대 학생 수
        int[][] room = new int[2][6]; //
        for (int i = 0; i < N; i++) {
            int S = sc.nextInt(); // 성별
            int Y = sc.nextInt(); // 학년
            room[S][Y - 1]++;
        }
        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                if(room[i][j] % K == 0) {
                    count += room[i][j] / K;
                } else {
                    count += room[i][j] / K + 1;
                }
            }
        }

        System.out.println(count);

    }
}
