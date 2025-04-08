import java.util.Scanner;

public class Main {
    static int answer, n;
    static int[][] board;
    static boolean[] visited;

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n+1][n+1];
        visited = new boolean[n+1];

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            board[x][y] = 1;
            board[y][x] = 1;
        }

        T.DFS(1);

        System.out.println(answer);
    }

    public void DFS(int v) {
        visited[v] = true;
        for (int i = 1; i <= n; i++) {
            if(board[v][i] == 1 && !visited[i]) {
                answer++;
                DFS(i);
            }
        }
    }

}
