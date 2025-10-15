import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        for(int i = 1; i <= N; i++){
            q1.offer(i);
        }
        sb.append("<");
        while (!q1.isEmpty()) {
            for (int i = 1; i < K; i++) {
                q1.offer(q1.poll());
            }
            sb.append(q1.poll());
            if (!q1.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}