import java.util.Scanner;

public class Main {

    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int[] eat = new int[d+1];
        int res = 1;
        eat[c]++;

        for(int i = 0 ; i < k ; i++) {
            if(eat[arr[i]]==0){ //처음먹은것이면 res증가
                res++;
            }
            eat[arr[i]]++;
        }

        int cnt = res;

        for(int i = 1 ; i < N; i++) {
            int pop = arr[i-1];
            eat[pop]--; //하나 뺌
            if(eat[pop]==0) cnt--; //종류가 없으면 count 감소

            int add = arr[(i+k-1)%N]; //회전초밥이라 n-k가 아님
            if(eat[add]==0) cnt++;
            eat[add]++;

            res = Math.max(res,cnt);
        }
        System.out.println(res);
    }
}