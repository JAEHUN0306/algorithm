import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스 개수

        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt(); // 편의점 개수

            ArrayList<Point> list = new ArrayList<>();

            // 집 좌표 (시작점)
            int homeX = sc.nextInt();
            int homeY = sc.nextInt();
            list.add(new Point(homeX, homeY));

            // 편의점 좌표
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                list.add(new Point(x, y));
            }

            // 페스티벌 좌표 (목적지)
            int festX = sc.nextInt();
            int festY = sc.nextInt();
            list.add(new Point(festX, festY));

            // BFS로 확인
            boolean result = BFS(list, n);

            if (result) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }

            list.clear(); // 다음 테스트 케이스를 위해 리스트 초기화
        }

        sc.close();
    }

    static boolean BFS(ArrayList<Point> list, int n) {
        Queue<Point> Q = new LinkedList<>();
        boolean[] visited = new boolean[n + 2]; // 집, 편의점들, 페스티벌

        // 시작점 (집)
        Q.offer(list.get(0));
        visited[0] = true;

        while (!Q.isEmpty()) {
            Point cur = Q.poll();

            // 현재 위치가 페스티벌(목적지)인지 확인
            if (cur.x == list.get(n + 1).x && cur.y == list.get(n + 1).y) {
                return true; // 목적지에 도착
            }

            // 현재 위치에서 갈 수 있는 모든 위치 확인 (집, 편의점들, 페스티벌)
            for (int i = 1; i < n + 2; i++) {
                if (!visited[i]) {
                    Point next = list.get(i);
                    // 맨해튼 거리 계산
                    int distance = Math.abs(cur.x - next.x) + Math.abs(cur.y - next.y);

                    // 맥주 20병으로 갈 수 있는 거리인지 확인 (1000m 이하)
                    if (distance <= 1000) {
                        Q.offer(next);
                        visited[i] = true;
                    }
                }
            }
        }

        return false; // 목적지에 도달할 수 없음
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}