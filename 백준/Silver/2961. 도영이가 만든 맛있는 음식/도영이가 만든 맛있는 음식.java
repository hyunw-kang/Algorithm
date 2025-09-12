

import java.util.*;

public class Main{
    static int n;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        dfs(0,1,0,false);
        System.out.println(min);
    }

    public static void dfs(int depth, int sSum, int bSum, boolean visited) {
        if (depth == n) {
            if(visited){
                min = Math.min(min, Math.abs(sSum - bSum));
            }
            return;
        }
        dfs(depth + 1, sSum * arr[depth][0], bSum + arr[depth][1], true);
        dfs(depth + 1, sSum, bSum,visited);
    }
}