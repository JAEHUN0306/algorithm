import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 개수
        int k = sc.nextInt(); // 무게 제한
        int[] dy = new int[k + 1];
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            for (int j = k; j >= w ; j--) {
                dy[j] = Math.max(dy[j], dy[j - w] + v);
            }
        }
        System.out.println(dy[k]);
    }
}
