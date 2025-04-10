import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] board = new int[n][m];
            int count = 0;

            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                board[y][x] = 1;
            }

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if(board[j][l] == 1) {
                        BFS(new Point(j, l), board);
                        count++;
                    }

                }
            }
            System.out.println(count);
        }
    }

    public static void BFS(Point p, int[][] board) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(p);
        board[p.x][p.y] = 0;

        while(!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Point cur = Q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    int ga = board.length;
                    int se = board[0].length;

                    if(nx >= 0 && ny >= 0 && nx < ga && ny < se && board[nx][ny] == 1) {
                        board[nx][ny] = 0;
                        Q.offer(new Point(nx, ny));
                    }
                }
            }
        }
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
