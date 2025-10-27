import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, result;
	static char[][] building;
	static boolean[][] sVisited;
	static boolean[][] fVisited;
	static Queue<Sang> sq;
	static Queue<Sang> fq;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < testcase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			building = new char[n][m];
			sVisited = new boolean[n][m];
			fVisited = new boolean[n][m];
			sq = new ArrayDeque<>();
			fq = new ArrayDeque<>();
			result = 0;

			for (int i = 0; i < n; i++) {
				String in = br.readLine();
				for (int j = 0; j < m; j++) {
					building[i][j] = in.charAt(j);
					if (building[i][j] == '@') {
						sq.add(new Sang(i, j, 0));
						sVisited[i][j] = true;
					} else if (building[i][j] == '*') {
						fq.add(new Sang(i, j, 0));
						fVisited[i][j] = true;
					}
				}
			}

			int ans = bfs();
			System.out.println(ans == -1 ? "IMPOSSIBLE" : ans);
		}
	}

	private static int bfs() {
		while (!sq.isEmpty()) {
			// 🔥 불 먼저 퍼뜨리기
			int fsize = fq.size();
			for (int t = 0; t < fsize; t++) {
				Sang fire = fq.poll();
				for (int i = 0; i < 4; i++) {
					int nx = fire.x + dx[i];
					int ny = fire.y + dy[i];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
					if (fVisited[nx][ny]) continue;
					if (building[nx][ny] == '#' || building[nx][ny] == '*') continue;
					fVisited[nx][ny] = true;
					building[nx][ny] = '*';
					fq.add(new Sang(nx, ny, 0));
				}
			}

			// 👤 상근 이동
			int ssize = sq.size();
			for (int t = 0; t < ssize; t++) {
				Sang sang = sq.poll();

				for (int i = 0; i < 4; i++) {
					int nx = sang.x + dx[i];
					int ny = sang.y + dy[i];

					// ✅ 탈출 성공
					if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
						return sang.time + 1;
					}

					if (sVisited[nx][ny]) continue;
					if (building[nx][ny] != '.') continue; // 벽(#), 불(*), 상근(@) 이동불가

					sVisited[nx][ny] = true;
					sq.add(new Sang(nx, ny, sang.time + 1));
				}
			}
		}
		return -1;
	}

	static class Sang {
		int x, y, time;
		Sang(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
}
