import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        visited = new int[100001];
        System.out.println(BFS(n, m));
    }

    public static int BFS(int x, int y) {
        int time = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(x);
        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                Integer cur = Q.poll();
                if (cur == y) return time;

                if (cur + 1 <= 100000 && visited[cur + 1] == 0) {
                    visited[cur + 1] = 1;
                    Q.offer(cur + 1);
                }
                if (cur - 1 >= 0 && visited[cur - 1] == 0) {
                    visited[cur - 1] = 1;
                    Q.offer(cur - 1);
                }

                if (cur * 2 <= 100000 && visited[cur * 2] == 0) {
                    visited[cur * 2] = 1;
                    Q.offer(cur * 2);
                }
            }
            time++;
        }
        return -1;
    }
}

