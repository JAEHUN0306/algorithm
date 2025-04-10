import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static char[][] board, weakness;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        board = new char[n][n];
        weakness = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j);

                if(board[i][j] == 'G') {
                    weakness[i][j] = 'R';
                } else {
                    weakness[i][j] = board[i][j];
                }
            }
        }

        System.out.print(BFS(board) + " " + BFS(weakness));

    }

    public static int BFS(char[][] board) {
        int count = 0;
        Queue<int[]> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 'R' || board[i][j] == 'G' || board[i][j] == 'B') {
                    char color = board[i][j]; // 현재 색상 저장

                    Q.offer(new int[]{i, j});
                    count++;

                    while(!Q.isEmpty()) {
                        int len = Q.size();
                        for (int k = 0; k < len; k++) {
                            int[] cur = Q.poll();
                            for (int l = 0; l < 4; l++) {
                                int nx = cur[0] + dx[l];
                                int ny = cur[1] + dy[l];
                                if(nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == color) {
                                    board[nx][ny] = 0;
                                    Q.offer(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
