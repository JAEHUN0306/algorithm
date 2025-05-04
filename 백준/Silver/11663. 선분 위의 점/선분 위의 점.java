import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] point = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            point[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(point);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int lt = 0;
            int rt = N - 1;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                if (point[mid] < start) {
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }
            int lowIndex = lt;

            lt = 0;
            rt = N - 1;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                if (point[mid] <= end) {
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }
            int upperIndex = lt;

            System.out.println(upperIndex - lowIndex);
        }
    }
}
