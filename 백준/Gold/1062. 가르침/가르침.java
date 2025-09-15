import java.util.Scanner;

public class Main{
    static int n, k;
    static int count;
    static String[] arr;
    static boolean[] visited = new boolean[26];
    static String[] alpha = {"a","n","t","i","c"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.next();
        }

        for (String s : alpha) {
            visited[s.charAt(0) - 'a'] = true;
        }

        subset(0, 0);
        System.out.println(count);
    }

    public static void subset(int idx, int cnt) {
        if (cnt == k - 5) {
            int temp = 0;
            for (int i = 0; i < arr.length; i++) {
                boolean canRead = true;
                for (int j = 0; j < arr[i].length(); j++) {
                    char c = arr[i].charAt(j);
                    if (!visited[c - 'a']) {
                        canRead = false;
                        break;
                    }
                }
                if (canRead) temp++;
            }
            count = Math.max(count, temp);
            return;
        }

        if (idx >= 26) return;

        if (visited[idx]) {
            subset(idx + 1, cnt);
            return;
        }

        visited[idx] = true;
        subset(idx + 1, cnt + 1);

        visited[idx] = false;
        subset(idx + 1, cnt);
    }
}