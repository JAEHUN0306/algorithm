import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split("-");

        int result = 0;

        String[] first = split[0].split("\\+");
        for (String str : first) {
            if (!str.isEmpty()) {
                result += Integer.parseInt(str);
            }
        }

        for (int i = 1; i < split.length; i++) {
            String[] add = split[i].split("\\+");
            int sum = 0;
            for (String str : add) {
                if (!str.isEmpty()) {
                    sum += Integer.parseInt(str);
                }
            }
            result -= sum;
        }

        System.out.println(result);
    }
}
