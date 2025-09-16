import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(factorial(n));
        scan.close();
    }

    public static long factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
}