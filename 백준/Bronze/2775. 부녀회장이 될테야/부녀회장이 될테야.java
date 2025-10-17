import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < T; t++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int[][] arr = new int[a+1][b+1];

            for(int i = 0; i <= b; i++){
                arr[0][i] = i;
            }

            for (int i = 1; i <= a; i++) {
                for (int j = 1; j <= b; j++) {
                    if (j == 1) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
                    }
                }
            }
            sb.append(arr[a][b]).append("\n");
        }
        System.out.print(sb.toString());
        sc.close();
    }
}