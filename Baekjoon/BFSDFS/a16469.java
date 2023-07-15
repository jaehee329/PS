import java.io.*;
import java.util.*;

public class a16469 {

    private static final char ROAD = '0';
    private static final int MOVES = 4;
    private static final int[] YMOVE = {-1, 1, 0, 0};
    private static final int[] XMOVE = {0, 0, -1, 1};

    private static int height;
    private static int width;
    private static char[][] map;
    private static boolean[][] nukVisit;
    private static boolean[][] swingVisit;
    private static boolean[][] changVisit;
    private static Queue<Position> nukPos = new LinkedList<>();
    private static Queue<Position> swingPos = new LinkedList<>();
    private static Queue<Position> changPos = new LinkedList<>();

    private static class Position {
        public int y;
        public int x;
        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        map = new char[height][width];
        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        nukVisit = new boolean[height][width];
        swingVisit = new boolean[height][width];
        changVisit = new boolean[height][width];

        st = new StringTokenizer(br.readLine());
        init(st, nukVisit, nukPos);
        st = new StringTokenizer(br.readLine());
        init(st, swingVisit, swingPos);
        st = new StringTokenizer(br.readLine());
        init(st, changVisit, changPos);


        int move = 1;
        while (!nukPos.isEmpty() || !swingPos.isEmpty() || !changPos.isEmpty()) {
            int converge = moveOnceAndReturnConverge();
            if (converge != 0) {
                System.out.println(move);
                System.out.println(countMeetPosition());
                return;
            }
            move++;
        }
        System.out.println("-1");
    }

    private static void init(StringTokenizer st, boolean[][] visit, Queue<Position> pos) {
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = Integer.parseInt(st.nextToken()) - 1;
        pos.add(new Position(y, x));
        visit[y][x] = true;
    }

    private static int moveOnceAndReturnConverge() {
        nukPos = bfsOnceAndReturnNextPos(nukVisit, nukPos);
        swingPos = bfsOnceAndReturnNextPos(swingVisit, swingPos);
        changPos = bfsOnceAndReturnNextPos(changVisit, changPos);
        return countMeetPosition();
    }

    private static Queue<Position> bfsOnceAndReturnNextPos(boolean[][] visit, Queue<Position> positions) {
        Queue<Position> nextPositions = new LinkedList<>();

        while (!positions.isEmpty()) {
            Position curPos = positions.poll();
            for (int i = 0; i < MOVES; i++) {
                int targetY = curPos.y + YMOVE[i];
                int targetX = curPos.x + XMOVE[i];

                if (targetY >= 0 && targetY < height && targetX >= 0 && targetX < width && map[targetY][targetX] == ROAD && !visit[targetY][targetX]) {
                    nextPositions.add(new Position(targetY, targetX));
                    visit[targetY][targetX] = true;
                }
            }
        }
        return nextPositions;
    }

    private static int countMeetPosition() {
        int meetPositionCount = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (nukVisit[i][j] == true && swingVisit[i][j] == true && changVisit[i][j] == true) {
                    meetPositionCount++;
                }
            }
        }
        return meetPositionCount;
    }

}
