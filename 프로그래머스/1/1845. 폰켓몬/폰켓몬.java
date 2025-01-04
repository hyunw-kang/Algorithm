import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length / 2;  
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int size = set.size();
        if (size >= len) {
            answer = len;
        } else {
            answer = size;
        }
        
        return answer;
    }
}