import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean visited[][];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int a, b;
    static int arr[][];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        arr = new int[a][b];
        visited = new boolean[a][b];
        sc.nextLine();
        for(int i = 0; i< a; i++){
            String str = sc.next();
            for(int j = 0; j < b; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        bfs(0,0);
        System.out.println(arr[a-1][b-1]);
    }
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});
        arr[x][y] = 1;
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int currentx = current[0];
            int currenty = current[1];
            for(int i = 0; i < 4; i++){
                int nextx = currentx + dx[i];
                int nexty = currenty + dy[i];
                if(nextx < 0 || nexty < 0 || nextx >= a || nexty >= b){
                    continue;
                }
                if(arr[nextx][nexty] == 1 && !visited[nextx][nexty]){
                    q.offer(new int[] {nextx,nexty});
                    visited[nextx][nexty] = true;
                    arr[nextx][nexty] = arr[currentx][currenty] + 1;
                }
            }
        }
    }
}
