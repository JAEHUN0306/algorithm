class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int zeroCount = 0;
        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                zeroCount++;
                continue;
            } else {
                for (int j = 0; j < 6; j++) {
                    if (lottos[i] == win_nums[j]) {
                        count++;
                        continue;
                    }
                }
            }
        }
        // 맞은 개수
        answer[0] = scoreToResult(count + zeroCount);
        answer[1] = scoreToResult(count);
        return answer;
    }

    public static int scoreToResult(int score) {
        switch (score) {
            case 0: return 6;
            case 1: return 6;
            case 2: return 5;
            case 3: return 4;
            case 4: return 3;
            case 5: return 2;
            case 6: return 1;
        }
        return score;
    }
}
