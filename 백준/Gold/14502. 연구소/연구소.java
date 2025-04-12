import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] board;
    static int[][] tempBoard;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int safeArea = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][m];
        tempBoard = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        buildWall(0);
        System.out.println(safeArea);
    }

    static void buildWall(int L) {
        if(L == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    tempBoard[i][j] = board[i][j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(tempBoard[i][j] == 2)
                        virusDFS(i, j);
                }
            }

            safeArea = Math.max(getArea(), safeArea);

        } else { // 벽이 새워지지 않았으면
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(board[i][j] == 0) {
                        board[i][j] = 1;
                        buildWall(L + 1);
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    static void virusDFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && tempBoard[nx][ny] == 0) {
                tempBoard[nx][ny] = 2;
                virusDFS(nx, ny);
            }
        }
    }

    static int getArea() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(tempBoard[i][j] == 0) count++;
            }
        }

        return count;
    }
}
