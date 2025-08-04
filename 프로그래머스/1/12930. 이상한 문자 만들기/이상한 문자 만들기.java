class Solution {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        String [] str = s.split("");
        
        int index = 0;
        
        for(int i = 0; i < str.length; i++){
            if(index % 2 == 0){
                str[i] = str[i].toUpperCase();
            }
            if(str[i].isBlank()){
                index = -1;
            }
            answer += str[i];
            index++;
        }
        return answer;
    }
}