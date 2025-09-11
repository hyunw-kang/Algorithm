class Solution {
    static int numbers[];
    static boolean visited[];
    static int N, answer, mine;
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        N = dungeons.length;
        mine = k;

        for (int i = N; i > 0; i--) {
            numbers = new int[i];
            visited = new boolean[N];
            permutation(i, 0, dungeons);
            if(answer > 0) break;
        }
        
        return answer;
    }
        public static void permutation(int size, int cnt, int[][] dungeons){
            if(cnt == size) {
            int temp = mine;
            int count = 0;
            for (int i = 0; i < numbers.length; i++){
                int index = numbers[i];
                int min = dungeons[index][0];
                int use = dungeons[index][1];
                if (temp >= min){
                    temp -= use;
                    count++;
                } else{
                    break;
                }
            }
            answer = Math.max(count, answer);
            return;
        }
            for(int i = 0; i < N; i++) {
                if(visited[i]) continue;
                visited[i] = true;
                numbers[cnt] = i;
                permutation(size, cnt + 1, dungeons);
                visited[i] = false;
            }   
        }
    }