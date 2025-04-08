import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] board;
    static int[][] visited;
    static int count;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int year = 0;

        while(true) {
            int icebergCount = countIceberg();
            visited = new int[n][m];

            if(icebergCount >= 2) {
                System.out.print(year);
                break;
            }

            if(icebergCount ==0) {
                System.out.print(0);
                break;
            }

            melt();
            year++;
        }
    }

    private static void melt() {
        int[][] tempMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] > 0) {
                    int seaCount = 0;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                            seaCount++;
                        }
                    }

                    tempMap[i][j] = Math.max(0, board[i][j] - seaCount);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = tempMap[i][j];
            }
        }
    }

    private static int countIceberg() {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] > 0 && visited[i][j] == 0) {
                    BFS(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void BFS(int x, int y) {
        visited[x][y] = 1;
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[] {x, y});
        while(!Q.isEmpty()) {
            int[] cur = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] > 0 && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    Q.offer(new int[]{nx, ny});
                }
            }
        }


    }

}
