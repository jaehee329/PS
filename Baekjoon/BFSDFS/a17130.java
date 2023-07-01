package Baekjoon.BFSDFS;

import java.io.*;
import java.util.*;

public class a17130 {

	private static final int[][] DIRECTIONS = {{0, 1}, {1, 1}, {-1, 1}};

	private static class Coord {
		int y;
		int x;

		public Coord(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		ArrayList<Coord> exits = new ArrayList<>();
		Coord initialRabbit = new Coord(0, 0);

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'R') {
                    initialRabbit = new Coord(i, j);
                } else if (map[i][j] == 'O') {
                    exits.add(new Coord(i, j));
                }
			}
		}

		boolean canExit = false;

		int[][] carrots = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(carrots[i], -1);
		}

		Queue<Coord> q = new LinkedList<>();
		q.offer(initialRabbit);
		carrots[initialRabbit.y][initialRabbit.x] = 0;

		while (!q.isEmpty()) {
			Coord current = q.poll();

			for (int[] DIRECTION : DIRECTIONS) {
				int nextY = current.y + DIRECTION[0];
				int nextX = current.x + DIRECTION[1];

				if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {
                    continue; 
                }
				if (map[nextY][nextX] == '#') {
                    continue;
                }
				if (map[nextY][nextX] == 'C') {
					if (carrots[nextY][nextX] < carrots[current.y][current.x] + 1) {
						carrots[nextY][nextX] = carrots[current.y][current.x] + 1;
						q.offer(new Coord(nextY, nextX));
					}
				} else {
					if (carrots[nextY][nextX] < carrots[current.y][current.x]) {
						carrots[nextY][nextX] = carrots[current.y][current.x];
						if (map[nextY][nextX] == 'O') {
                            canExit = true;
                        }
						q.offer(new Coord(nextY, nextX));
					}
				}
			}
		}

		int max = 0;
		for(Coord point : exits){
			max = Math.max(max, carrots[point.y][point.x]);
		}
	
        if (canExit) {
            System.out.println(max);
        } else {
            System.out.println("-1");
        }
	}
}
