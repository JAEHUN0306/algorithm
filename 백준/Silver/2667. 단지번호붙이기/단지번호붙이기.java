import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int[][] board;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }
        
        int houseCount = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 1) {
                    houseCount++;
                    board[i][j] = 0;
                    list.add(T.DFS(i, j));
                }
            }
        }
        Collections.sort(list);
        System.out.println(houseCount);
        for (int i : list) {
            System.out.println(i);
        }
    }
    public int DFS(int x, int y) {
        int count = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                count += DFS(nx, ny);
            }
        }
        return count;
    }
}
