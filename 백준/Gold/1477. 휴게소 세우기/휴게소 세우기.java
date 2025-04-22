import java.util.*;

public class Main {
    static List<Integer> positions = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt(); // 7개 새울꺼임
        int l = sc.nextInt();

        for (int i = 0; i < n; i++) {
            positions.add(sc.nextInt());
        }
        positions.add(0);
        positions.add(l);
        Collections.sort(positions);

        int lt = 1;
        int rt = l;
        int answer = 0;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;

            if(needRestArea(mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println(answer);
    }

    private static int needRestArea(int mid) {
        int count = 0;

        for (int i = 1; i < positions.size(); i++) {
            int d = positions.get(i) - positions.get(i - 1);

            count += (d - 1) / mid;
        }

        return count;

    }
}
