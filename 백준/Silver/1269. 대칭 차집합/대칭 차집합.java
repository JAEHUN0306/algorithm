import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> set1 = new HashSet<>();
        while(st.hasMoreTokens()) {
            set1.add(Integer.parseInt(st.nextToken()));
        }


        st = new StringTokenizer(br.readLine());
        Set<Integer> set2 = new HashSet<>();
        while(st.hasMoreTokens()) {
            set2.add(Integer.parseInt(st.nextToken()));
        }

        int symmetricDifference = 0;

        for(int x : set1) {
            if(!set2.contains(x)) symmetricDifference++;
        }

        for(int x : set2) {
            if(!set1.contains(x)) symmetricDifference++;
        }

        System.out.println(symmetricDifference);
    }
}
