import java.io.*;
import java.util.*;

public class Main {
    static int Edge_arr[][];
    static boolean Visited_arr[];
    static int N;
    static int M;
    static int count;
    static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        Edge_arr = new int[N + 1][N + 1];
        Visited_arr = new boolean[N + 1];
        count = 0;
        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            Edge_arr[a][b] = Edge_arr[b][a] = 1;
        }
        dfs(1);
        System.out.print(count-1);
    }

    public static void dfs(int v){
        Visited_arr[v] = true;
        count++;
        for(int i = 1; i <= N; i++){
            if(Edge_arr[v][i] == 1 && Visited_arr[i] == false) {
                dfs(i);
            }
        }
    }
}
