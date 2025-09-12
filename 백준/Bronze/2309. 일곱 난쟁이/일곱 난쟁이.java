
import java.util.Arrays;
import java.util.Scanner;

public class Main{

    static int[] numbers = new int[7];
    static int[] input = new int[9];
    static boolean found = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < 9; i++) {
            input[i] = scan.nextInt();
        }
        combination(0,0);
    }

    public static void combination(int depth, int start) {
        if(found) return; 
        if(depth == 7) {
            int sum = 0;
            for(int i = 0; i < 7; i++) {
                sum += numbers[i];
            }

            if(sum == 100) {
                Arrays.sort(numbers);
                for(int i = 0; i < 7; i++) {
                    System.out.println(numbers[i]);
                }
                found = true;
            }
            return;
        }

        for(int i = start; i < 9; i++){
            numbers[depth] = input[i];
            combination(depth+1, i+1);
        }
    }
}
