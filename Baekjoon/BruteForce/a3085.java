package Baekjoon.BruteForce;

import java.io.*;

public class a3085 {
    private static int N;
    private static int[] left = new int[]{0, -1};
    private static int[] right = new int[]{0, 1};
    private static int[] up = new int[]{-1, 0};
    private static int[] down = new int[]{1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int maxLength = findMaxLengthWithOutChange(board);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j != N - 1 && board[i][j] != board[i][j + 1]) {
                    int partialMaxLength = getRightwardChangeMaxLength(board, i, j);
                    maxLength = maxLength < partialMaxLength ? partialMaxLength : maxLength;
                }
                if (i != N - 1 && board[i][j] != board[i + 1][j]) {
                    int partialMaxLength = getDownwardChangeMaxLength(board, i, j);
                    maxLength = maxLength < partialMaxLength ? partialMaxLength : maxLength;
                }
            }
        }
        System.out.println(maxLength);
    }

    private static int findMaxLengthWithOutChange(char[][] board) {
        int maxLength = 0;
        // horizontal
        for (int i = 0; i < N; i++) {
            char target = board[i][0];
            int length = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == target) {
                    length++;
                } else {
                    target = board[i][j];
                    maxLength = length > maxLength ? length : maxLength;
                    length = 1;
                }
            }
            maxLength = length > maxLength ? length : maxLength;
        }
        // vertical
        for (int j = 0; j < N; j++) {
            char target = board[0][j];
            int length = 1;
            for (int i = 1; i < N; i++) {
                if (board[i][j] == target) {
                    length++;
                } else {
                    target = board[i][j];
                    maxLength = length > maxLength ? length : maxLength;
                    length = 1;
                }
            }
            maxLength = length > maxLength ? length : maxLength;
        }
        return maxLength;
    }

    private static int getRightwardChangeMaxLength(char[][] board, int i, int j) {
        int[][] searchAxis = {left, up, up, right};
        boolean[] searchBiDirection = {false, true, true, false};
        int[][] searchTarget = {{0, 0}, {0, 0}, right, right};
        changeWithRightward(board, i, j);
        int maxLength = 0;
        for (int k = 0; k < 4; k++) {
            int partialMaxLength = findPartialMaxLengthFrom(board, i + searchTarget[k][0], j + searchTarget[k][1], searchAxis[k], searchBiDirection[k]);
            maxLength = maxLength < partialMaxLength ? partialMaxLength : maxLength;
        }
        changeWithRightward(board, i, j);
        return maxLength;
    }

    private static void changeWithRightward(char[][] board, int i, int j) {
        char origin = board[i][j];
        board[i][j] = board[i][j + 1];
        board[i][j + 1] = origin;
    }

    private static int getDownwardChangeMaxLength(char[][] board, int i, int j) {
        int[][] searchAxis = {up, right, right, down};
        boolean[] searchBiDirection = {false, true, true, false};
        int[][] searchTarget = {{0, 0}, {0, 0}, down, down};
        changeWithDownward(board, i, j);
        int maxLength = 0;
        for (int k = 0; k < 4; k++) {
            int partialMaxLength = findPartialMaxLengthFrom(board, i + searchTarget[k][0], j + searchTarget[k][1], searchAxis[k], searchBiDirection[k]);
            maxLength = maxLength < partialMaxLength ? partialMaxLength : maxLength;
        }
        changeWithDownward(board, i, j);
        return maxLength;
    }

    private static void changeWithDownward(char[][] board, int i, int j) {
        char origin = board[i][j];
        board[i][j] = board[i + 1][j];
        board[i + 1][j] = origin;
    }

    private static int findPartialMaxLengthFrom(char[][] board, int i, int j, int[] direction, boolean isBiDirection) {
        int maxLength = 1;
        int distance = 1;
        char origin = board[i][j];
        while (true) {
            int[] increment = {direction[0] * distance, direction[1] * distance};
            int y = i + increment[0];
            int x = j + increment[1];
            if (x >= 0 && x < N && y >= 0 && y < N) {
                if (board[y][x] == origin) {
                    maxLength++;
                    distance++;
                    continue;
                }
            }
            break;
        }
        distance = 1;
        if (isBiDirection) {
            while (true) {
                int[] increment = {-1 * direction[0] * distance, -1 * direction[1] * distance};
                int y = i + increment[0];
                int x = j + increment[1];
                if (x >= 0 && x < N && y >= 0 && y < N) {
                    if (board[y][x] == origin) {
                        maxLength++;
                        distance++;
                        continue;
                    }
                }
                break;
            }
        }
        return maxLength;
    }
}
