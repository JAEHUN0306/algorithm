import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int count = 0;  // 제거된 인형 쌍 카운트
        Stack<Integer> stack = new Stack<>();  // 바구니
        
        for(int i = 0; i < moves.length; i++) {
            int col = moves[i] - 1;  // moves 배열은 1부터 시작하므로 인덱스를 0부터 시작하게 조정
            
            // 해당 열에서 위에서부터 0이 아닌 첫 번째 인형을 찾음
            for(int j = 0; j < board.length; j++) {
                if (board[j][col] != 0) {
                    // 인형을 찾았을 때
                    int doll = board[j][col];
                    board[j][col] = 0;  // 인형을 집어 올렸으므로 0으로 설정
                    
                    // 바구니의 맨 위 인형과 같은지 확인
                    if(!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();  // 같은 인형이면 제거
                        count++;
                    } else {
                        stack.push(doll);
                    }
                    
                    break;
                }
            }
        }
        
        return count * 2;
    }
}