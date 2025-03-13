import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        
        LinkedList<Character> edit = new LinkedList<>();
        for (char c : s.toCharArray()) {
            edit.add(c);
        }
        
        ListIterator<Character> cursor = edit.listIterator(edit.size());
        
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            char cmd = command.charAt(0);
            
            switch (cmd) {
                case 'L':
                    if (cursor.hasPrevious()) cursor.previous();
                    break;
                case 'D':
                    if (cursor.hasNext()) cursor.next();
                    break;
                case 'B':
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case 'P':
                    cursor.add(command.charAt(2));
                    break;
            }
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (char c : edit) {
            bw.write(c);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}