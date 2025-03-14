import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] dis;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n+1][m+1];
        dis = new int[n+1][m+1];

        // 공백 없이 붙어서 주어지는 입력 처리
        sc.nextLine(); // 첫 줄의 개행문자 처리
        for (int i = 1; i <= n; i++) {
            String line = sc.nextLine();
            for (int j = 1; j <= m; j++) {
                // 각 문자를 숫자로 변환 ('0'은 48, '1'은 49 아스키 값)
                board[i][j] = line.charAt(j-1) - '0';
            }
        }

        System.out.println(T.solution(n, m, board));
    }

    public int solution(int n, int m, int[][] board) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(1, 1));
        board[1][1] = 0; // 방문 처리
        dis[1][1] = 1;   // 시작 위치도 카운트

        while(!Q.isEmpty()) {
            Point poll = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if(nx >= 1 && nx <= n && ny >= 1 && ny <= m && board[nx][ny] == 1) {
                    Q.offer(new Point(nx, ny));
                    board[nx][ny] = 0; // 방문 처리
                    dis[nx][ny] = dis[poll.x][poll.y] + 1;
                }
            }
        }

        return dis[n][m];
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}