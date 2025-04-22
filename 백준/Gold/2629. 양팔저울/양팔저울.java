import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int[] grams;
    static int[][] memo;
    static int n;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        // 1, 4 가 주어지면. 1, 4, 4 - 1, 4 + 1; 1, 3, 4, 5 -> list.contains
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grams = new int[n];
        memo = new int[n][15001];
        for (int i = 0; i < n; i++) {
            grams[i] = sc.nextInt();
        }

        DFS(0, 0);

        int m = sc.nextInt();
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
            if(set.contains(nums[i])) {
                System.out.print("Y" + " ");
            } else {
                System.out.print("N" + " ");
            }
        }

    }

    static void DFS(int L, int gram) {
        if(gram > 0) {
            set.add(gram);
        }
        if(L == n || memo[L][gram] == 1) { // 조합 완성 됐으면,
            return;
        } else {
            memo[L][gram] = 1;
            DFS(L + 1, grams[L] + gram);
            DFS(L + 1, Math.abs(grams[L] - gram));
            DFS(L + 1, gram);
        }
    }
}
