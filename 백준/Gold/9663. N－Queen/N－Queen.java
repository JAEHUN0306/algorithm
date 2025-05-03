import java.util.Scanner;

public class Main {
    static int n;
    static int[][] board;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];

        DFS(0);
        System.out.println(count);
    }

    public static void DFS(int L) {
        if(L == n) { // 조합이 완성되면
            count++;
        } else {
            for(int i = 0; i < n; i++) { // 현재 행의 i열에 퀸을 놓을 수 있는지 확인
                if(isPossible(L, i)) {
                    board[L][i] = 1;
                    DFS(L + 1);
                    board[L][i] = 0;
                }
            }
        }
    }

    public static boolean isPossible(int row, int col) {
        // 같은 열 확인
        for(int i = 0; i < row; i++) {
             if(board[i][col] == 1) {
                return false;
            }
        }

        // 왼쪽 위 대각선 확인
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }

        // 오른쪽 위 대각선 확인
        for(int i = row-1, j = col+1; i >= 0 && j < n; i--, j++) {
            if(board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}