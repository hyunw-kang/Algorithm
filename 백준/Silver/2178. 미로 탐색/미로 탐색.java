import java.awt.Point;
import java.util.*;

public class Main{
    static int a, b;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        arr = new int[a][b];
        visited = new boolean[a][b];
        sc.nextLine();

        for (int i = 0; i < a; i++) {
            String line = sc.next();
            for (int j = 0; j < b; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);   // 시작위치

        System.out.println(arr[a - 1][b - 1]);

    }

    static void bfs(int x, int y) {

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = currentPoint.x + dx[i];
                int nextY = currentPoint.y + dy[i];

                if (nextX < 0 || nextX >= a || nextY < 0 || nextY >= b)
                    continue;
                if (arr[nextX][nextY] == 0)
                    continue;
                if (visited[nextX][nextY])
                    continue;
                queue.offer(new Point(nextX, nextY));
                visited[nextX][nextY] = true;

                arr[nextX][nextY] = arr[currentPoint.x][currentPoint.y] + 1;
            }
        }
    }
}