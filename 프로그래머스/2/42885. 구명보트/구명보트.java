import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people); // 50 50 70 80
        int lt = 0;
        int rt = people.length -1;
        int count = 0;
        
        while(lt <= rt) {
            count++;
            if(people[lt] + people[rt] <= limit) {
                lt++;
                rt--;
            } else{
                rt--;
            }
        }
        
        return count;
    }
}