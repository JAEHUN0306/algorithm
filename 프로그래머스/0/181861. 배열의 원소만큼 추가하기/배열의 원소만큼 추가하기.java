class Solution {
    public int[] solution(int[] arr) {
        int sum = 0;
        for(int x : arr) {
            sum += x;
        }
        int[] answer = new int[sum];
        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i]; j++) {
                answer[index++] = arr[i];
            }
        }
        return answer;
    }
}