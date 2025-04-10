import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] board;
    static int[][][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        board = new int[n][m];
        visited = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(BFS());
    }

    public static int BFS() {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(0, 0, 0));
        visited[0][0][0] = 1;

        while(!Q.isEmpty()) {
            Point cur = Q.poll();

            if(cur.x == n - 1 && cur.y == m - 1) {
                return visited[cur.x][cur.y][cur.broken];
            }

            for (int j = 0; j < 4; j++) {
                int nx = cur.x + dx[j];
                int ny = cur.y + dy[j];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if(board[nx][ny] == 1 && cur.broken == 0) {
                    visited[nx][ny][1] = visited[cur.x][cur.y][0] + 1;
                    Q.offer(new Point(nx, ny, 1));
                } else if(board[nx][ny] == 0 && visited[nx][ny][cur.broken] == 0) {
                    visited[nx][ny][cur.broken] = visited[cur.x][cur.y][cur.broken] + 1;
                    Q.offer(new Point(nx, ny, cur.broken));
                }
            }
        }
        return -1;
    }

    static class Point {
        int x, y, broken;

        public Point(int x, int y, int broken) {
            this.x = x;
            this.y = y;
            this.broken = broken;
        }
    }
}
