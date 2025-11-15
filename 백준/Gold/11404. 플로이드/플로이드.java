import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 10000000;
    public static void floyd(int[][] graph, int n){
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(graph[i][j] == INF) System.out.print(0+" ");
                else System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        int[][] graph = new int[n+1][n+1];
        for(int i=1; i<= n; i++) {
            for(int j=1 ; j<= n; j++) {
                graph[i][j] = INF;

                if(i == j) {
                    graph[i][j] = 0;
                }
            }
        }
        StringTokenizer st;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[x][y] = Math.min(cost, graph[x][y]);
        }
        floyd(graph, n);
    }
}
