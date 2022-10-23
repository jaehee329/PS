import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1873 {
	private static class Tank {
		int Y;
		int X;
		char dir;
		public Tank(int Y, int X, char dir) {
			this.Y = Y;
			this.X = X;
			this.dir = dir;
		}
	}

	private static StringBuilder sb = new StringBuilder();
	private static Tank tank;
	private static char[][] map;
	private static int H;
	private static int W;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int i=1; i<=TC; i++) {
			setStaticVar(br);
			doMoves(br);
            setTankLocation();
			addSb(i);
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

	private static void setStaticVar(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		map = new char[H][W];
		for (int i=0; i<H; i++) {
			String s = br.readLine();
			for (int j=0; j<W; j++) {
				char c = s.charAt(j);
				if (isDirection(c)) {
					map[i][j] = '.';
                    tank = new Tank(i, j, c);
				} else {
					map[i][j] = c;
				}
			}
		}
	}

	private static boolean isDirection(char c) {
		if (c=='^' || c=='v' || c=='<' || c=='>') {
			return true;
		}
		return false;
	}

	private static void doMoves(BufferedReader br) throws IOException {
		int len = Integer.parseInt(br.readLine());
		String moves = br.readLine();
		for (int i=0; i<len; i++) {
			char c = moves.charAt(i);
			switch (c) {
				case 'U':
					moveUp();
					break;
				case 'D':
					moveDown();
					break;
				case 'L':
					moveLeft();
					break;
				case 'R':
					moveRight();
					break;
				case 'S':
					shoot();
			}
		}
	}

	private static void moveUp() {
		tank.dir = '^';
		if (movable(-1, 0)) {
			tank.Y -= 1;
		}
	}

	private static void moveDown() {
		tank.dir = 'v';
		if (movable(1, 0)) {
			tank.Y += 1;
		}
	}

	private static void moveLeft() {
		tank.dir = '<';
		if (movable(0, -1)) {
			tank.X -= 1;
		}
	}

	private static void moveRight() {
		tank.dir = '>';
		if (movable(0, 1)) {
			tank.X += 1;
		}
	}

	private static boolean movable(int Y, int X) {
		int tarY = tank.Y+Y;
		int tarX = tank.X+X;
		if (tarY>=0 && tarY<H && tarX>=0 && tarX<W) {
			if (map[tarY][tarX]=='.') {
				return true;
			}
		}
		return false;
	}

	private static void shoot() {
		int y = tank.Y;
		int x = tank.X;
		char dir = tank.dir;
		int tarY = y;
		int tarX = x;
		int t = 0;
		switch(dir){
			case '<':
				t = x;
				while (t>=0) {
					if (map[y][t] == '*') {
						tarX = t;
						break;
					} else if (map[y][t] == '#') {
						break;
					}
					t--;
				}
				break;
			case '>':
				t = x;
				while (t<W) {
					if (map[y][t] == '*') {
						tarX = t;
						break;
					} else if (map[y][t] == '#') {
						break;
					}
					t++;
				}
				break;
			case '^':
				t = y;
				while (t>=0) {
					if (map[t][x] == '*') {
						tarY = t;
						break;
					} else if (map[t][x] == '#') {
						break;
					}
					t--;
				}
				break;
			case 'v':
				t = y;
				while (t<H) {
					if(map[t][x] == '*') {
						tarY = t;
						break;
					} else if (map[t][x] == '#') {
						break;
					}
					t++;
				}
		}
		map[tarY][tarX] = '.';
	}

    private static void setTankLocation() {
        map[tank.Y][tank.X] = tank.dir;
    }
	private static void addSb(int idx) {
		sb.append("#" + idx + " ");
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
	}
}
