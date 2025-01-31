class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int min = Integer.parseInt(arr[0]);
        int max = Integer.parseInt(arr[0]);
       
        for (String num : arr) {
            int current = Integer.parseInt(num);
            if (current < min) {
                min = current;
            }
            if (current > max) {
                max = current;
            }
        }
        answer = min + " " + max;
        return answer;
    }
}