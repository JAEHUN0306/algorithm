import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int F, S, G, U, D;
    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt(); // 총 층수
        S = sc.nextInt(); // 현위치
        G = sc.nextInt(); // 목표지점
        U = sc.nextInt(); // +층수
        D = sc.nextInt(); // -층수
        visited = new int[F + 1];

        int count = BFS(S, G);
        if(count == -1) System.out.print("use the stairs");
        else System.out.print(count);
    }

    public static int BFS(int x, int y) {
        int count = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(x);
        visited[x] = 1;
        while(!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Integer cur = Q.poll();
                if(cur == y) return count;

                if(cur + U <= F && visited[cur + U] == 0) {
                    visited[cur + U] = 1;
                    Q.offer(cur + U);
                }

                if(cur - D >= 1 && visited[cur - D] == 0) {
                    visited[cur - D] = 1;
                    Q.offer(cur - D);
                }
            }
            count++;
        }
        return -1;
    }
}
