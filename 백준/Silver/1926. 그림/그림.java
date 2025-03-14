import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int count = 0, max = 0;
    static int n, m;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 세로
        m = sc.nextInt(); // 가로
        int[][] board = new int[n][m]; // n행 m열로 변경

        for (int i = 0; i < n; i++) { // 세로(행)에 대한 루프
            for (int j = 0; j < m; j++) { // 가로(열)에 대한 루프
                board[i][j] = sc.nextInt();
            }
        }
        T.solution(board);
    }

    public void solution(int[][] board) {
        Queue<Point> Q = new LinkedList<>();

        for (int i = 0; i < n; i++) { // 세로(행)에 대한 루프
            for (int j = 0; j < m; j++) { // 가로(열)에 대한 루프
                if (board[i][j] == 1) {
                    int area = 1; // 각 그림마다 area 초기화
                    count++;
                    board[i][j] = 0;
                    Q.offer(new Point(i, j));

                    while(!Q.isEmpty()) {
                        Point poll = Q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = poll.x + dx[k];
                            int ny = poll.y + dy[k];
                            if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 1) {
                                Q.offer(new Point(nx, ny));
                                board[nx][ny] = 0;
                                area++;
                            }
                        }
                    }

                    if(area > max) {
                        max = area;
                    }
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}