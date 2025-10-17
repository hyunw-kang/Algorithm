import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        int[] nums = new int[c];
        for (int i = 0; i < c; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < c; i++) {
            int n = nums[i];
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 3; k++) {
                    if (j - k >= 0) dp[j] += dp[j - k];
                }
            }
            System.out.println(dp[n]);
        }
    }
}