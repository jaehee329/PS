import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        Board brd = new Board(m, n, board);
        int deletion = 0;
        while (true) {
            int count = brd.proceedAndReturnDeletions();
            if (count == 0) {
                break;
            }
            deletion += count;
        }
        return deletion;
    }
    
    private static class Board {
        
        private final char[][] board;
        private final int height;
        private final int width;
        
        public Board(int height, int width, String[] lines) {
            this.board = new char[height][width];
            for (int i = 0; i < height; i++) {
                String line = lines[i];
                for (int j = 0; j < width; j++) {
                    board[i][j] = line.charAt(j);
                }
            }
            this.height = height;
            this.width = width;
        }
        
        public int proceedAndReturnDeletions() {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            Set<Coord> changes = new HashSet<>();
            boolean[][] visit = new boolean[height][width];
            proceed(changes, visit);
            pullDown(changes);
            return changes.size();
        }
        
        private void proceed(Set<Coord> changes, boolean[][] visit) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (!visit[i][j] && board[i][j] != 'X') {
                        visit[i][j] = true;
                        visitNearBy(changes, visit, i, j);
                    }
                }
            }
        }
        
        private void visitNearBy(Set<Coord> changes, boolean[][] visit, int centerY, int centerX) {
            checkDirection(changes, visit, centerY, centerX, 1, 1);
            checkDirection(changes, visit, centerY, centerX, -1, 1);
            checkDirection(changes, visit, centerY, centerX, 1, -1);
            checkDirection(changes, visit, centerY, centerX, -1, -1);
        }
        
        private void checkDirection(Set<Coord> changes, boolean[][] visit, int centerY, int centerX, int directionY, int directionX) {
            char center = board[centerY][centerX];
            int targetY = centerY + directionY;
            int targetX = centerX + directionX;
            if (targetY >= 0 && targetY < height && targetX >= 0 && targetX < width) {
                if (center == board[targetY][targetX]) {
                    if (center == board[centerY][targetX] && center == board[targetY][centerX]) {
                        visit[targetY][targetX] = true;
                        visit[centerY][targetX] = true;
                        visit[targetY][centerX] = true;
                        changes.add(new Coord(targetY, targetX));
                        changes.add(new Coord(centerY, targetX));
                        changes.add(new Coord(targetY, centerX));
                        changes.add(new Coord(centerY, centerX));
                    }
                }
            }
        }
        
        private void pullDown(Set<Coord> changes) {
            for (int x = 0; x < width; x++) {
                int offset = 0;
                int[] offsets = new int[height];
                for (int y = height - 1; y >= 0; y--) {
                    offsets[y] = offset;
                    if (changes.contains(new Coord(y, x))) {
                        offset++;
                    }
                }
                for (int y = height - 1; y >= 0; y--) {
                    board[y + offsets[y]][x] = board[y][x];
                }
                for (int y = 0; y < offsets[0]; y++) {
                    board[y][x] = 'X';
                }
            }
        }
    }
    
    private static class Coord {
        public final int y;
        public final int x;
        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Coord coord = (Coord) o;
            return y == coord.y && x == coord.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}