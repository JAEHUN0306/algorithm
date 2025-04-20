import java.util.Scanner;

public class Main {
    static int[] nums;
    static int[] ch;
    static int n, s;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();

        nums = new int[n];
        ch = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        DFS(0, 0, 0);
        System.out.println(count);
    }

    static void DFS(int L, int sum, int element) {
        if(L ==  n) {// 부분 수열이 완성 됐으면
            if (sum == s && element != 0) count++;
        } else {
            DFS(L + 1, sum + nums[L], element + 1);
            DFS(L + 1, sum, element);
        }
    }
}
