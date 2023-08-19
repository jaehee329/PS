class Solution {
    private static final int[][] WIN_POSITIONS = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    public int solution(String[] board) {
        char[] chars = (board[0] + board[1] + board[2]).toCharArray();
        int oCount = 0;
        int xCount = 0;
        for (int i = 0; i < 9; i++) {
            char c = chars[i];
            if (c == 'O') {
                oCount++;
            } else if (c == 'X') {
                xCount++;
            }
        }

        boolean oWin = false;
        boolean xWin = false;
        for (int i = 0; i < 8; i++) {
            int[] pos = WIN_POSITIONS[i];
            if (chars[pos[0]] == chars[pos[1]] && chars[pos[1]] == chars[pos[2]]) {
                if ('O' == chars[pos[0]]) {
                    oWin = true;
                } else if ('X' == chars[pos[1]]) {
                    xWin = true;
                }
            }
        }

        if (oCount != xCount + 1 && oCount != xCount) {
            return 0;
        }
        if (oWin && oCount != xCount + 1) {
            return 0;
        }
        if (xWin && oCount != xCount) {
            return 0;
        }
        return 1;
    }
}
