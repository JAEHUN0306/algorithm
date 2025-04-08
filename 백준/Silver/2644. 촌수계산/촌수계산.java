import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int[][] board;
    static int[] visited;
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int m = sc.nextInt();
        board = new int[n + 1][n + 1];
        visited = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            board[a][b] = 1;
            board[b][a] = 1;
        }

        System.out.println(T.BFS(x, y));
    }

    public int BFS(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();
        visited[x] = 1;
        Q.offer(x);
        int level = 0;

        while(!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Integer cur = Q.poll();

                if(cur == y) return level;

                for (int j = 1; j <= n; j++) {
                    if(board[cur][j] == 1 && visited[j] == 0) {
                        visited[j] = 1;
                        Q.offer(j);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
