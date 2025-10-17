import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            long[][] arr = new long[n+1][m+1];

            for(int j = 0; j <= m; j++){
                arr[0][j] = 1;
            }

            for(int k = 1; k <= n; k++){
                for(int j = k; j <= m; j++){
                    if(j == 0 || j == k){
                        arr[k][j] = 1;
                    } else {
                        arr[k][j] = arr[k -1][j-1] + arr[k][j-1];
                    }
                }
            }
            sb.append(arr[n][m]).append("\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }
}