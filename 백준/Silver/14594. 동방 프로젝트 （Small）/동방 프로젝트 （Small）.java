import java.util.Scanner;

public class Main {
    static int[] unf;

    public static int find(int x) {
        if (unf[x] != x) {
            unf[x] = find(unf[x]);
        }
        return unf[x];
    }

    public static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);

        if (fx != fy) {
            unf[fy] = fx;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        unf = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            for (int j = a; j < b; j++) {
                union(j, j + 1);
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (find(i) == i) {
                count++;
            }
        }

        System.out.println(count);
    }
}
