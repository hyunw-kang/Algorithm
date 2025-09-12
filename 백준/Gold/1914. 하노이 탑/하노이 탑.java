import java.util.*;
import java.math.BigInteger;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void call(int n, int start, int end, int temp){
        if(n == 1){
            if(N <= 20) { 
                sb.append(start).append(" ").append(end).append("\n");
            }
            return;
        }
        call(n-1, start, temp, end);
        if(N <= 20) {
            sb.append(start).append(" ").append(end).append("\n");
        }
        call(n-1, temp, end, start);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        BigInteger count = BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE);
        System.out.println(count);
        
        if(N <= 20){
            call(N, 1, 3, 2);
            System.out.print(sb);
        }
    }
}