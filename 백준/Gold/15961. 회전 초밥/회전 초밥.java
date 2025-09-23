import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N,d,k,c;
    static int[] sushi, visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tk.nextToken());
        d = Integer.parseInt(tk.nextToken());
        k = Integer.parseInt(tk.nextToken());
        c = Integer.parseInt(tk.nextToken());
        sushi = new int[N];
        visited = new int[d+1];

        for(int i=0; i<N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        int total = 0, max = 0;
        // k개의 window를 처리

        for(int i = 0; i < k; i++){
            int idx = sushi[i];
            if(visited[idx] == 0){  //먹은 초밥이 아니면 total++
                total++;
            }
            visited[sushi[i]]++;
        }
        max = total;

        // 쿠폰 처리
        if(visited[c] == 0) {
            max++;
        }
        // 회전초밥이라 n-k개가 아니라 n개만큼 반복
        for(int i = 0; i < N; i++){
            visited[sushi[i]]--;
            if(visited[sushi[i]] == 0){ // 안먹어본건 --
                total--;
            }
            // 윈도우의 start분 빼고 window의 end분 새로 더하기
            int index = (i + k) % N; // 회전초밥이라 %N
            if(visited[sushi[index]] == 0){
                total++;
            }
            visited[sushi[index]]++;
            // max값 갱신
            max = Math.max(max, visited[c] == 0 ? total + 1 : total);
        }
        System.out.println(max);
    }
}
