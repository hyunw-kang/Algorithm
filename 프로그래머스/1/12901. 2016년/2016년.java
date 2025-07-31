class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] month = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        
        int count = 0;
        for(int i = 0; i < a ; i++){
            count += month[i];
        }
        count += b;
        
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        answer = days[(count-1) % 7];
        return answer;
    }
}