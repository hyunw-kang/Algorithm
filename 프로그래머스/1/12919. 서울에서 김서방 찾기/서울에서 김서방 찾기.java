class Solution {
    public String solution(String[] seoul) {
        int index = 0;
        String answer = "";
        for(int i =0; i < seoul.length; i++){
            if(seoul[i].equals("Kim")){
                index = i;
            }
            answer = "김서방은 " + index + "에 있다";
        }
        return answer;
    }
}