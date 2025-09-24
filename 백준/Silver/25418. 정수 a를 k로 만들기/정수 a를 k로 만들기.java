import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] bfs = new int[k+1];
        for(int i = a; i < k; i++) {
            bfs[i+1] = bfs[i+1] == 0 ? bfs[i] + 1 : Math.min(bfs[i+1], bfs[i] + 1);
            if(i*2 <= k) {
                bfs[i*2] = bfs[i*2] == 0 ? bfs[i] + 1 : Math.min(bfs[i*2], bfs[i] + 1);
            }
        }
        System.out.print(bfs[k]);
    }
}
