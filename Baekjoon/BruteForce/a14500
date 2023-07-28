import java.io.*;
import java.util.*;

public class a14500 {

    private static int height;
    private static int width;
    private static int[][] map;
    private static final List<Polyomino> POLYOMINOS = List.of(
            new Polyomino(List.of(new Square(Direction.RIGHT), new Square(Direction.RIGHT), new Square(Direction.RIGHT))),
            new Polyomino(List.of(new Square(Direction.DOWN), new Square(Direction.DOWN), new Square(Direction.DOWN))),

            new Polyomino(List.of(new Square(Direction.RIGHT), new Square(Direction.DOWN), new Square(Direction.LEFT))),

            new Polyomino(List.of(new Square(Direction.RIGHT), new Square(Direction.DOWN), new Square(Direction.DOWN))),
            new Polyomino(List.of(new Square(Direction.LEFT), new Square(Direction.DOWN), new Square(Direction.DOWN))),
            new Polyomino(List.of(new Square(Direction.RIGHT), new Square(Direction.RIGHT), new Square(Direction.UP))),
            new Polyomino(List.of(new Square(Direction.RIGHT), new Square(Direction.RIGHT), new Square(Direction.DOWN))),
            new Polyomino(List.of(new Square(Direction.DOWN), new Square(Direction.DOWN), new Square(Direction.RIGHT))),
            new Polyomino(List.of(new Square(Direction.DOWN), new Square(Direction.DOWN), new Square(Direction.LEFT))),
            new Polyomino(List.of(new Square(Direction.LEFT), new Square(Direction.LEFT), new Square(Direction.UP))),
            new Polyomino(List.of(new Square(Direction.LEFT), new Square(Direction.LEFT), new Square(Direction.DOWN))),

            new Polyomino(List.of(new Square(Direction.DOWN), new Square(Direction.RIGHT), new Square(Direction.DOWN))),
            new Polyomino(List.of(new Square(Direction.DOWN), new Square(Direction.LEFT), new Square(Direction.DOWN))),
            new Polyomino(List.of(new Square(Direction.RIGHT), new Square(Direction.UP), new Square(Direction.RIGHT))),
            new Polyomino(List.of(new Square(Direction.RIGHT), new Square(Direction.DOWN), new Square(Direction.RIGHT))),

            new Polyomino(List.of(new Square(Direction.RIGHT), new Square(Direction.RIGHT), new Square(Direction.LEFT, false), new Square(Direction.DOWN))),
            new Polyomino(List.of(new Square(Direction.RIGHT), new Square(Direction.RIGHT), new Square(Direction.LEFT, false), new Square(Direction.UP))),
            new Polyomino(List.of(new Square(Direction.DOWN), new Square(Direction.DOWN), new Square(Direction.UP, false), new Square(Direction.LEFT))),
            new Polyomino(List.of(new Square(Direction.DOWN), new Square(Direction.DOWN), new Square(Direction.UP, false), new Square(Direction.RIGHT)))
    );

    private enum Direction {

        UP(new Position(-1, 0)),
        DOWN(new Position(1, 0)),
        LEFT(new Position(0, -1)),
        RIGHT(new Position(0, 1));

        public final Position position;

        Direction(Position position) {
            this.position = position;
        }
    }

    private static class Position {

        public int y;
        public int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public boolean isValid() {
            return y >= 0 && y < height && x >= 0 && x < width;
        }
    }

    private static class Square {

        public Direction direction;
        public boolean willBeAdded;

        public Square(Direction direction, boolean willBeAdded) {
            this.direction = direction;
            this.willBeAdded = willBeAdded;
        }

        public Square(Direction direction) {
            this.direction = direction;
            this.willBeAdded = true;
        }

        public Position moveNext(Position position) {
            return new Position(position.y + direction.position.y, position.x + direction.position.x);
        }

        public int getIncrement(Position position) {
            if (position.isValid() && willBeAdded) {
                return map[position.y][position.x];
            }
            return 0;
        }
    }

    private static class Polyomino {

        public List<Square> squares;

        public Polyomino(List<Square> squares) {
            this.squares = squares;
        }

        public int getIncrement(Position position) {
            int increment = map[position.y][position.x];
            for (Square square : squares) {
                position = square.moveNext(position);
                increment += square.getIncrement(position);
            }
            return increment;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        map = new int[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (Polyomino polyomino : POLYOMINOS) {
                    max = Math.max(max, polyomino.getIncrement(new Position(i, j)));
                }
            }
        }
        System.out.println(max);
    }
}
