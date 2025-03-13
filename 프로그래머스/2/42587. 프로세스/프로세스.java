import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<People> Q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            Q.offer(new People(i, priorities[i]));
        }
        
        while(!Q.isEmpty()) {
            People people = Q.poll();
            boolean hasHigherPriority = false;

            for(People p : Q) {
                if(p.prior > people.prior) {
                    hasHigherPriority = true;
                    Q.offer(people);
                    break;
                }
            }
            
            if(!hasHigherPriority) {
                answer++;
                if(people.num == location) {
                    return answer;
                }
            }
        }
        return answer;
    }
    
    static class People {
        int num;
        int prior;
        
        public People(int num, int prior) {
            this.num = num;
            this.prior = prior;
        }
    }
}