package baekjoon;

// https://www.acmicpc.net/problem/1005

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 1<=N<=1000
// 1<=K<=100000
// 1<=X,Y,W<=N
// 0<=D<=1000
public class Q1005_2 {

	public static int dp(int N, int K, int[] time, int[][] rule, int target, int[][] to_find_order) {
		int[] dp = new int[N + 1];

		// 아래의 두 단락은 dp를 돌리기 위한 순서를 뽑아내는 부분. 하지만 여기서 2중 for문으로 시간 효율성을 떨어뜨린다.
		int[][] sum = new int[N][2];
		for (int i = 0; i < N; i++) {
			sum[i][1] = i + 1; // 실제 사용할 index를 저장하는 구문
			for (int j = 1; j <= N; j++) {
				sum[i][0] += to_find_order[i + 1][j]; // 노드의 최종 layer 계산

			}
		}

		Arrays.sort(sum, new Comparator<int[]>() { // 2차원 배열의 정렬법 꼭 익혀두자
			public int compare(int[] A, int[] B) { // layer 기준으로 2차원 배열을 정렬
				int e1 = A[0];
				int e2 = B[0];
				return Integer.compare(e2, e1);
			}
		});

		// dp를 이용한 문제 해결 부분
		for (int i = 1; i <= target; i++) {
			int max = 0;
			for (int j = 1; j <= N; j++) {
				if (rule[j][sum[i - 1][1]] == 1 && max <= dp[j])
					max = dp[j]; // rule[j][sum[i-1][1]] : sum의 1번째 열에 정렬된 index가 들어있다.
				dp[sum[i - 1][1]] = max + time[sum[i - 1][1]];
			}
		}

		return dp[target];
	}

	public static void checker(int[][] to_find_order, int N, int x) {
		for (int k = 1; k <= N; k++) {
			if (to_find_order[k][x] != 0) {
				to_find_order[k][x]++;

				checker(to_find_order, N, k);
			}
		}
		return;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {

			int N = sc.nextInt(); // 건물의 수
			int K = sc.nextInt(); // 규칙의 수
			int[] time = new int[N + 1]; // 각 건물을 짓는데 걸리는 시간
			int[][] rule = new int[N + 1][N + 1]; // 규칙의 내용
			int[][] to_find_order = new int[N + 1][N + 1];

			for (int j = 1; j <= N; j++) {
				time[j] = sc.nextInt();
			}

			int[] x_order = new int[K];
			for (int j = 0; j < K; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				rule[x][y] = 1;

				x_order[j] = x; // 1번부터 건물이 순서되로 빌드가 된다는 조건이 없기 때문에 dp를 돌릴 순서를 뽑아낼 수 있어야 한다.
				to_find_order[x][y] = 1; // 초기 배열의 깊은 복사를 위한 구문

			}

			for (int j = 0; j < x_order.length; j++) {
				checker(to_find_order, N, x_order[j]); // 재귀를 통해 노드의 layer를 찾아낸다. 하지만, 이 구문에서 시간복잡도가 많이 증가한다.
			}

			int target = sc.nextInt(); // 승리를 위해 지어야 할 건물
			System.out.println(dp(N, K, time, rule, target, to_find_order));
		}
		sc.close();
	}
}