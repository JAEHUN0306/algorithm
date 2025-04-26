import java.util.Scanner;

public class Main {
    static int n, t, result;
    static int[] nums;
    public static void main(String[] args) {
        /*
        N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
         */
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();

        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        DFS(0, 0, 0);
        System.out.println(result);
    }

    public static void DFS(int L, int sum, int elements) {
        if(L == n) {
            if (elements > 0 && sum == t) result++;
        } else {
            DFS(L + 1, sum + nums[L], elements + 1);
            DFS(L + 1, sum, elements);
        }
    }
}
