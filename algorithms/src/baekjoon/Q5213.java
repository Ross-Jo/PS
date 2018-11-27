package baekjoon;

// https://www.acmicpc.net/problem/5213

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Pair { // 각 지점의 좌표 
	int first;
	int second;
	Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

//참고 : https://gist.github.com/Baekjoon/f5026b4e4b13a4bbed1287803729e785
public class Q5213 {
	static int n;
	static int[][][] a = new int[500][500][2]; // 각 블록이 가지고 있는 정보 저장  
	static boolean[][] check = new boolean[500][500]; // map의 방문여부 체크 
	static Pair[][] from = new Pair[500][500]; // 경로 추적을 위함 
	static int[][] dist = new int[500][500]; // 출발지에서 해당 타일까지의 거리기록을 위함 
	static int[] dx0 = { -1, -1, 0, 0, 1, 1 };
	static int[] dy0 = { -1, 0, -1, 1, -1, 0 };
	static int[] dx1 = { -1, -1, 0, 0, 1, 1 };
	static int[] dy1 = { 0, 1, -1, 1, 0, 1 };

	static boolean ok(int x, int y) {
		if (x < 0 || x >= n) return false; // row 범위 맞는지 확인 
		if (x % 2 == 0) return y >= 0 && y < n; // 짝수 인덱스 row인 경우 y범위 맞는지 확인 
		else return y >= 0 && y < n - 1; // 홀수 인덱스 row인 경우 y범위 맞는지 확인 
	}

	static boolean go(int x1, int y1, int x2, int y2) { // 문제의 조건에 따른 진행이 가능한지 확인하는 함수 
		if (x1 == x2) { // 같은 줄인데 
			if (y1 < y2) return a[x1][y1][1] == a[x2][y2][0]; // 오른쪽인 경우 
			else return a[x1][y1][0] == a[x2][y2][1]; // 왼쪽인 경우 
		} else { // 다른줄인 경우 
			if (x1 % 2 == 0) { // 짝수 인덱스 줄인 경우 
				if (y1 == y2) return a[x1][y1][1] == a[x2][y2][0];
				else return a[x1][y1][0] == a[x2][y2][1];
			} else { // 홀수 인덱스 줄인 경우 
				if (y1 == y2) return a[x1][y1][0] == a[x2][y2][1];
				else return a[x1][y1][1] == a[x2][y2][0];
			}
		}
	}

	static int num(int x, int y) {
		int ans = x / 2 * (n * 2 - 1); // 시작점 지정 
		if (x % 2 == 1) ans += n; // 홀수 인덱스를 가지는 줄이면 n만큼 이동 
		ans += y + 1; // 해당 줄에 오면 y값을 이용해서 블록의 번호를 산출함 
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) { // 일단 홀수/짝수줄 모두 적어도 N-1개의 타일을 가지고 있기 때문에 이렇게 받음
				a[i][j][0] = sc.nextInt(); // 3차원 배열
				a[i][j][1] = sc.nextInt();
			}
			if (i % 2 == 0) { // 만약 짝수 줄인 경우에는 1개의 블록을 더 받음 
				a[i][n - 1][0] = sc.nextInt();
				a[i][n - 1][1] = sc.nextInt();
			}
		}
		Queue<Pair> q = new LinkedList<Pair>();
		check[0][0] = true; // 방문여부 체크 
		dist[0][0] = 1; // 해당 타일까지의 거리를 기록  
		q.add(new Pair(0, 0)); // 시작점 삽입 - pair가 나타내는 것은 각 지점의 좌표  
		while (!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.first;
			int y = p.second;
			for (int k = 0; k < 6; k++) { // 탐색 가능여부에 대한 확인 
				int nx, ny;
				if (x % 2 == 0) { // 0, 2 ~ 등 짝수 인덱스 row일때의 방문 가능 경로 
					nx = x + dx0[k];
					ny = y + dy0[k];
				} else { // 1, 3 ~ 등 홀수 인덱스 row일때의 방문 가능 경로 
					nx = x + dx1[k];
					ny = y + dy1[k];
				}
				
				if (ok(nx, ny) == false) continue; // 범위 체크 
				if (go(x, y, nx, ny) == false) continue;
				if (check[nx][ny] == true) continue; // 방문 여부 확인 및 이미 방문한 지점이면 다시 방문하지 않음 
				
				check[nx][ny] = true; // 방문여부 확인 
				dist[nx][ny] = dist[x][y] + 1; // 새로운 타일까지의 거리를 기록 
				from[nx][ny] = new Pair(x, y); // 새로운 타일에 도달했다면, 그게 어디서 왔는지 기록하기 위함 
				q.add(new Pair(nx, ny)); // 큐에 새로운 경로 삽입 
			}
		}
		int x = n - 1; // 제일 오른쪽 아래 지점부터 위의 탐색코드가 어디서 끝난 것인지 찾을건데 
		int y = n - 1;
		while (check[x][y] == false) { // 종료지점을 찾는 행위 
			y -= 1; // 왼쪽으로 하나씩 당기다가 
			if (y < 0) { // 음수가 나오면 
				x -= 1; // 이전 row로 올라가서 
				y = n - 1; // 다시 오른쪽 끝에서 부터 시작하는데 
				if (x % 2 == 1) y -= 1; // 홀수 라인인 경우는 블럭이 하나 적으니까 한칸 더 빼줌 
			}
		}
		System.out.println(dist[x][y]); // 그리고 그 지점으로 이동하기까지 위해 움직인 거리를 출력해주고 
		Stack<Pair> s = new Stack<Pair>();
		while (!(x == 0 && y == 0)) { // 시작지점까지 거슬러 올라가면서 
			s.push(new Pair(x, y)); // 해당 지점을 스택에 넣어주고  
			Pair p = from[x][y]; // 그리고 그 지점 직전에 어디 있었는지 알려주는 정보를 이용해 
			x = p.first; // x,y를 갱신하면서, 시작지점까지 찾아나간다. 
			y = p.second;
		}
		s.push(new Pair(x, y)); // 시작 지점 경로도 하나 넣어주고! 
		while (!s.isEmpty()) { // 그리고 그 경로를 주욱 출력 
			System.out.print(num(s.peek().first, s.peek().second) + " ");
			s.pop();
		}
		System.out.println();
		sc.close();
	}
}