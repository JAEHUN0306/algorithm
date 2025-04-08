import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][][] board;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int m, n, h; // 가로, 세로, 높이
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();

        board = new int[n][m][h];

        for (int k= 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board[i][j][k] = sc.nextInt();
                }
            }
        }

        System.out.println(BFS());
    }

    public static int BFS() {
        Queue<Point> Q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < h; k++) {
                    if(board[i][j][k] == 1) {
                        Q.offer(new Point(i, j, k));
                    }
                }
            }
        }

        int days = -1;

        while(!Q.isEmpty()) {
            int len = Q.size();
            days++;

            for (int i = 0; i < len; i++) {
                Point cur = Q.poll();

                for (int j = 0; j < 6; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    int nz = cur.z + dz[j];

                    if(nx >= 0 && ny >= 0 && nz >= 0 && nx < n && ny < m && nz < h && board[nx][ny][nz] == 0) {
                        board[nx][ny][nz] = 1;
                        Q.offer(new Point(nx, ny, nz));
                    }
                }
            }
        }

        if(!allRipe()) {
            return -1;
        }

        return days;
    }
    
    public static boolean allRipe() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < h; k++) {
                    if(board[i][j][k] == 0) return false;
                }
            }
        }
        return true;
    }

    public static class Point {
        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
