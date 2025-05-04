import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static int R, C;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // N이 1 이하면 그대로 출력
        if (N <= 1) {
            printBoard();
            return;
        }

        // N이 짝수면 모든 칸이 폭탄
        if (N % 2 == 0) {
            setBomb();
            printBoard();
            return;
        }

        // N이 홀수일 때 (3, 5, 7, ...)
        // 초기 폭탄 위치 저장
        Queue<Point> firstBombs = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'O') {
                    firstBombs.offer(new Point(i, j));
                }
            }
        }

        // N % 4 == 3인 경우: 한 번 폭발한 모습
        if (N % 4 == 3) {
            setBomb();
            BFS(firstBombs);
            printBoard();
        }
        // N % 4 == 1인 경우: 두 번 폭발한 모습
        else { // N % 4 == 1
            // 첫 번째 폭발 과정
            setBomb();
            BFS(firstBombs);

            // 현재 폭탄 위치 저장
            Queue<Point> secondBombs = new LinkedList<>();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] == 'O') {
                        secondBombs.offer(new Point(i, j));
                    }
                }
            }

            // 두 번째 폭발 과정
            setBomb();
            BFS(secondBombs);
            printBoard();
        }
    }

    static void BFS(Queue<Point> Q) {
        while (!Q.isEmpty()) {
            Point cur = Q.poll();

            board[cur.x][cur.y] = '.';

            for (int j = 0; j < 4; j++) {
                int nx = cur.x + dx[j];
                int ny = cur.y + dy[j];
                if(nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    board[nx][ny] = '.';
                }
            }
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 모든 칸에 폭탄('O') 설치
    static void setBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                board[i][j] = 'O';
            }
        }
    }

    static void printBoard() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}