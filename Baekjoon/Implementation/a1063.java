import java.io.*;
import java.util.*;

public class a1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] kingPos = toCoord(st.nextToken());
        int[] rockPos = toCoord(st.nextToken());
        int moves = Integer.parseInt(st.nextToken());

        for (int i = 0; i < moves; i++) {
            int[] move = toMove(br.readLine());
            int kingToY = kingPos[0] + move[0];
            int kingToX = kingPos[1] + move[1];
            if (kingToY >= 0 && kingToY < 8 && kingToX >= 0 && kingToX < 8) {
                if (kingToY == rockPos[0] && kingToX == rockPos[1]) {
                    int rockToY = rockPos[0] + move[0];
                    int rockToX = rockPos[1] + move[1];
                    if (rockToY >= 0 && rockToY < 8 && rockToX >= 0 && rockToX < 8) {
                        rockPos[0] = rockToY;
                        rockPos[1] = rockToX;
                        kingPos[0] = kingToY;
                        kingPos[1] = kingToX;
                    }
                } else {
                    kingPos[0] = kingToY;
                    kingPos[1] = kingToX;
                }
            }
        }
        System.out.println(toPos(kingPos));
        System.out.println(toPos(rockPos));
    }

    private static int[] toCoord(String coord) {
        return new int[]{coord.charAt(1) - '1', coord.charAt(0) - 'A'};
    }

    private static int[] toMove(String move) {
        int[] m = {0, 0};
        for (char c : move.toCharArray()) {
            int[] mv = toMove(c);
            m[0] += mv[0];
            m[1] += mv[1];
        }
        return m;
    }

    private static int[] toMove(char move) {
        switch (move) {
            case 'R':
                return new int[]{0, 1};
            case 'L':
                return new int[]{0, -1};
            case 'B':
                return new int[]{-1, 0};
            default:
                return new int[]{1, 0};
        }
    }

    private static String toPos(int[] coord) {
        return Character.toString('A' + coord[1]) + (1 + coord[0]);
    }
}
