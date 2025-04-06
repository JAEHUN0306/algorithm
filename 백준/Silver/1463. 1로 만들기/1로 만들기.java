import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int count;
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(T.BFS(x));

    }

    public int BFS(int x) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(x);
        int level = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Integer cur = Q.poll();
                if(cur == 1) return level;
                if(cur % 3 == 0) Q.offer(cur / 3);
                if(cur % 2 == 0) Q.offer(cur / 2);
                if(cur - 1 > 0) Q.offer(cur - 1);
            }
            level++;
        }
        return -1;
    }
}
