import java.util.*;

public class Main {
    static int[] ch = new int[2000001];
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        System.out.println(T.solution(n, nums, m));
    }
    
    public int solution(int n, int[] arr, int m) {
        int count = 0;
        for(int i = 0; i < n ; i ++) {
            if(m - arr[i] > 0 && ch[m - arr[i]] == 1) count++;
            ch[arr[i]] = 1;
        }       
        return count;
    }
}