import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static char[][][] board;
    static int[][][] visited;
    static int[] dx = {0, 0, 0, 0, -1, 1};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int L, R, C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            L = sc.nextInt(); // 층 수
            R = sc.nextInt(); // 행
            C = sc.nextInt(); // 열

            if(L == 0 && R == 0 && C == 0) break;

            sc.nextLine(); // 버퍼 비우기

            Point startPoint = null;
            board = new char[L][R][C];
            visited = new int[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = sc.nextLine();  // 또는 sc.nextLine()
                    for (int k = 0; k < C; k++) {
                        board[i][j][k] = line.charAt(k);
                        if(board[i][j][k] == 'S') startPoint = new Point(i, j, k);
                    }
                }
                if (i < L - 1) {
                    sc.nextLine();  // 빈 줄 처리
                }
            }

            BFS(startPoint);
        }
    }

    static void BFS(Point point) {
        Queue<Point> Q = new LinkedList<>();
        visited[point.z][point.x][point.y] = 0;
        Q.offer(point);
        while(!Q.isEmpty()) {
            int len = Q.size();
                Point cur = Q.poll();
                if(board[cur.z][cur.x][cur.y] == 'E') {
                    System.out.println("Escaped in "+ visited[cur.z][cur.x][cur.y] + " minute(s).");
                    return;
                }
                for (int j = 0; j < 6; j++) {
                    int nz = cur.z + dz[j];
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if(nx >= 0 && ny >= 0 && nz >= 0 && nx < R && ny < C && nz < L && (board[nz][nx][ny] == '.' || board[nz][nx][ny] == 'E')
                       && visited[nz][nx][ny] == 0) {
                    visited[nz][nx][ny] = visited[cur.z][cur.x][cur.y] + 1;
                    Q.offer(new Point(nz, nx, ny));
                }
            }
        }
        System.out.println("Trapped!");
    }

    static class Point{
        int z, x, y;

        public Point(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
}
