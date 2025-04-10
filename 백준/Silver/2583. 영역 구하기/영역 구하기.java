import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];

        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int j = x1; j < x2; j++) {
                for (int l = y1; l < y2; l++) {
                    board[l][j] = 1;
                }

            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 0) {
                    BFS(new int[]{i, j});
                    count++;
                }
            }
        }
        System.out.println(count);
        Collections.sort(list);
        for(int x : list) {
            System.out.print(x + " ");
        }
    }

    public static void BFS(int[] p) {
        int count = 1;
        board[p[0]][p[1]] = 1;
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[] {p[0], p[1]});
        while(!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int[] cur = Q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if(nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] == 0) {
                        count++;
                        board[nx][ny] = 1;
                        Q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        list.add(count);
    }
}
