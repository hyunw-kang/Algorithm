

import java.util.Scanner;

public class Main {

    static int n, m;
    static int map[][];
    static int chicken[][];
    static int house[][];
    static int chCnt, hCnt;
    static int numbers[];
    static int answer = Integer.MAX_VALUE;
    static boolean visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        house = new int[2*n*n][2];
        chicken = new int[13][2];
        numbers = new int[m];
        chCnt = hCnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) {
                    house[hCnt++] = new int[]{i,j};
                } else if(map[i][j] == 2) {
                    chicken[chCnt++] = new int[]{i,j};
                }
            }
        }

        combi(0,0);
        System.out.println(answer);
    }

    public static void combi(int depth, int start){
        if(depth == m){
            int sum = 0;
            for(int i = 0; i < hCnt; i++){
                int dis = Integer.MAX_VALUE;
                for(int j = 0; j < m; j++){
                    int temp = Math.abs(house[i][0] - chicken[numbers[j]][0]) +
                            Math.abs(house[i][1] - chicken[numbers[j]][1]);
                    dis = Math.min(dis, temp);
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
            return;
        }

        for(int i = start; i < chCnt; i++){
            numbers[depth] = i;
            combi(depth+1, i+1);
        }
    }
}