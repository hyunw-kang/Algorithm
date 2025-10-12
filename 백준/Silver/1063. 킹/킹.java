import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String kingPos = scanner.next();
        String stonePos = scanner.next();
        int n = scanner.nextInt();  

        Map<String, int[]> directions = new HashMap<>();
        directions.put("R", new int[]{0, 1});
        directions.put("L", new int[]{0, -1});
        directions.put("B", new int[]{-1, 0});
        directions.put("T", new int[]{1, 0});
        directions.put("RT", new int[]{1, 1});
        directions.put("LT", new int[]{1, -1});
        directions.put("RB", new int[]{-1, 1});
        directions.put("LB", new int[]{-1, -1});

        int kingX = kingPos.charAt(1) - '1';
        int kingY = kingPos.charAt(0) - 'A';
        int stoneX = stonePos.charAt(1) - '1';
        int stoneY = stonePos.charAt(0) - 'A';

        for (int i = 0; i < n; i++) {
            String move = scanner.next();
            int[] dir = directions.get(move);

            int newKingX = kingX + dir[0];
            int newKingY = kingY + dir[1];

            if (isInsideBoard(newKingX, newKingY)) {
                if (newKingX == stoneX && newKingY == stoneY) {
                    int newStoneX = stoneX + dir[0];
                    int newStoneY = stoneY + dir[1];

                    if (isInsideBoard(newStoneX, newStoneY)) {
                        stoneX = newStoneX;
                        stoneY = newStoneY;
                        kingX = newKingX;
                        kingY = newKingY;
                    }
                } else {
                    kingX = newKingX;
                    kingY = newKingY;
                }
            }
        }

        System.out.println((char) (kingY + 'A') + "" + (kingX + 1));
        System.out.println((char) (stoneY + 'A') + "" + (stoneX + 1));
    }

    private static boolean isInsideBoard(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}