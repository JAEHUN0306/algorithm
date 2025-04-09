import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> Q = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            Q.offer(i);
        }
        int count = 1;
        while(!Q.isEmpty()) {
            if(count == k) {
                Integer cur = Q.poll();
                answer.add(cur);
                count = 1;
            } else {
                Integer cur = Q.poll();
                Q.offer(cur);
                count++;
            }
        }
        System.out.print("<");
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i));
            if (i < answer.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}
