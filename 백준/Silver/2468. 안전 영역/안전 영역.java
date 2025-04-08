import java.util.Scanner;

public class Main {
    static int n, max = 1;
    static int maxArea;
    static int[][] board;
    static int[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] > max) {
                    max = board[i][j];
                }
            }
        }

        for(int h = 0; h <= max; h++) {
            visited = new int[n][n];
            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(board[i][j] > h && visited[i][j] == 0) {
                        DFS(i, j, h);
                        count++;
                    }
                }
            }

            maxArea = Math.max(count, maxArea);
        }

        System.out.println(maxArea);
    }

    public static void DFS(int x, int y, int h) {
        visited[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] > h && visited[nx][ny] == 0) {
                DFS(nx, ny, h);
            }
        }


    }
}
