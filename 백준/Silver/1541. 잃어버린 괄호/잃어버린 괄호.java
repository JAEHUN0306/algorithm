import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String[] split = s.split("-");

        String[] start = split[0].split("\\+");
        int result = 0;
        for (String str : start) {
            if(!str.isEmpty()) { // '-'로 시작하면 빈 문자열
            result += Integer.parseInt(str);
            }
        }

        for (int i = 1; i < split.length; i++) {
            String[] addPart = split[i].split("\\+");
            int sum = 0;
            for (String add : addPart) {
                sum += Integer.parseInt(add);
            }
            result -= sum;
        }
        System.out.println(result);
    }
}
