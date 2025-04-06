import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static int[] nums;
    static int[] visited;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 카드 개수
        int k = sc.nextInt(); // 선택 개수
        nums = new int[n];
        visited = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        T.DFS(0, k, "");
        System.out.println(set.size());

    }

    public void DFS(int L, int k, String s) {
        if(L == k) {
            set.add(s);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if(visited[i] == 0) {
                    visited[i] = 1;
                    DFS(L + 1, k, s + nums[i]);
                    visited[i] = 0;
                }
            }
        }
    }
}
