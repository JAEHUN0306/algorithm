import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] graph;
    static int[] visited;
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int v = sc.nextInt();
        graph = new int[n + 1][n + 1];
        visited = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        T.DFS(v);
        System.out.println();
        visited = new int[n + 1];
        T.BFS(v);
    }

    public void DFS(int v){
        visited[v] = 1;
        System.out.print(v + " ");
        for (int i = 1; i <= n; i++) {
            if(graph[v][i] == 1 && visited[i] == 0) {
                visited[i] = 1;
                DFS(i);
            }
        }
    }

    public void BFS(int v) {
        Queue<Integer> Q = new LinkedList<>();
        visited[v] = 1;
        Q.offer(v);
        System.out.print(v + " ");

        while(!Q.isEmpty()) {
            int cur = Q.poll();
            for (int i = 1; i <= n; i++) {
                if(graph[cur][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    Q.offer(i);
                    System.out.print(i + " ");
                }
            }
        }
    }
}

