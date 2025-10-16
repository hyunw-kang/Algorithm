import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] visitOrder;
    static int N;
    static int M;
    static int V;
    static int order = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visitOrder = new int[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(V);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visitOrder[i]).append('\n');
        }
        System.out.print(sb);
    }

    public static void dfs(int v) {
        visitOrder[v] = order++;
        for (int next : graph[v]) {
            if (visitOrder[next] == 0) {
                dfs(next);
            }
        }
    }
}
