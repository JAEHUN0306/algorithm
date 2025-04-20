import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Sticker[] stickers = new Sticker[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            stickers[i] = new Sticker(R, C);
        }
        Arrays.sort(stickers); // 스티커 넓이 기준으로 내림차순
        int maxArea = 0;
        for (int i = 0; i < N; i++) {
            if (H >= stickers[i].height && W >= stickers[i].width) {
                int area1 = stickers[i].height * stickers[i].width;
                // 스티커 2
                for (int j = i + 1; j < N; j++) {
                    if((H - stickers[i].height >= stickers[j].height && stickers[j].width <= W) ||
                            (H >= stickers[j].height && stickers[j].width <= W - stickers[i].width)) {
                        int area2 = stickers[j].height * stickers[j].width;
                        maxArea = Math.max(area1 + area2, maxArea);
                        break;
                    }
                    // 스티커 2 회전
                    else if((H - stickers[i].height >= stickers[j].width && stickers[j].height <= W) ||
                            (H >= stickers[j].width && stickers[j].height <= W - stickers[i].width)) {
                        int area2 = stickers[j].height * stickers[j].width;
                        maxArea = Math.max(area1 + area2, maxArea);
                        break;
                    }
                }
            }
            //스티커 1 회전
            if (stickers[i].width <= H && stickers[i].height <= W) {
                int area1 = stickers[i].height * stickers[i].width;
                for (int j = i + 1; j < N; j++) {

                    // 스티커 1이 회전함에 따라 조건 변경
                    if ((H - stickers[i].width >= stickers[j].height && stickers[j].width <= W) ||
                            (stickers[j].height <= H && W - stickers[i].height >= stickers[j].width)) {
                        int area2 = stickers[j].height * stickers[j].width;
                        maxArea = Math.max(maxArea, area1 + area2);
                        break;
                    }

                    // 스티커 2 회전
                    else if ((H - stickers[i].width >= stickers[j].width && stickers[j].height <= W) ||
                            (stickers[j].width <= H && W - stickers[i].height >= stickers[j].height)) {
                        int area2 = stickers[j].height * stickers[j].width;
                        maxArea = Math.max(maxArea, area1 + area2);
                        break;
                    }
                }
            }
        }
        System.out.println(maxArea);
    }
    public static class Sticker implements Comparable<Sticker> {
        int height, width;
        public Sticker(int height, int width) {
            this.height = height;
            this.width = width;
        }
        @Override
        public int compareTo(Sticker o) {
            return (o.height * o.width) - (this.height * this.width);
        }
    }
}