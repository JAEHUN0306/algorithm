import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, 0, 0, -1, 1};
    static int[] dy = {0, 0, -1, 1, 0 ,0};
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int h, n, m;
    static int[][][] tomatoes; // h, n, m

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        tomatoes = new int[h][n][m];

        boolean already = true;
        Queue<Point> Q = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
                    if(tomatoes[i][j][k] == 0) already = false;
                    if(tomatoes[i][j][k] == 1) Q.offer(new Point(i, j, k));
                }
            }
        }
        if (already){ // 이미 다 익은 경우
            System.out.println(0);
            return;
        }
        BFS(Q);

        int maxDay = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(tomatoes[i][j][k] == 0) { // 다 익은 후에도 안익은게 있으면
                        System.out.println(-1);
                        return;
                    } else {
                        if(maxDay < tomatoes[i][j][k]) {
                            maxDay = tomatoes[i][j][k];
                        }
                    }
                }
            }
        }
        System.out.println(maxDay - 1);
    }

    static void BFS(Queue<Point> Q) {
        while(!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Point cur = Q.poll();
                for (int j = 0; j < 6; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    int nz = cur.z + dz[j];
                    if(nx >= 0 && ny >= 0 && nz >= 0 && nx < m && ny < n && nz < h && tomatoes[nz][ny][nx] == 0) {
                        tomatoes[nz][ny][nx] = tomatoes[cur.z][cur.y][cur.x] + 1;
                        Q.offer(new Point(nz, ny, nx));
                    }
                }
            }
        }
    }

    static class Point {
        int z, y, x;

        public Point(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
}
