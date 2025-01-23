import java.util.ArrayList;

class Solution {
    public int[] solution(int[] numbers) {
        // 중복 제거와 동적 크기 관리를 위해 ArrayList 사용
        ArrayList<Integer> tempAnswer = new ArrayList<>();
        
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                boolean exists = false;
                for (int num : tempAnswer) {
                    if (num == sum) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    tempAnswer.add(sum);
                }
            }
        }
        int[] answer = new int[tempAnswer.size()];
        for (int i = 0; i < tempAnswer.size(); i++) {
            answer[i] = tempAnswer.get(i);
        }
        for (int i = 0; i < answer.length - 1; i++) {
            for (int j = 0; j < answer.length - 1 - i; j++) {
                if (answer[j] > answer[j + 1]) {
                    int temp = answer[j];
                    answer[j] = answer[j + 1];
                    answer[j + 1] = temp;
                }
            }
        }

        return answer;
    }
}
