package baekjoon;

//https://www.acmicpc.net/problem/16235

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Q16235 {
	static int N, M, K;
	static int[][] A, T, V;
	static ArrayList<Integer>[][] L;
	static int[] xs = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] ys = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	static void spring() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				check(i, j);
			}
		}
	}
	
	static void fall() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				propagation(i, j);
			}
		}
	}
	
	static void winter() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				V[i][j] += A[i][j];
			}
		}
	}
	
	static void check(int i, int j) {
		int v = 0;
		int size = L[i][j].size();
		int stop = 0;
		for (int target=0; target<size; target++) {
			int age = L[i][j].get(target);
			if (age <= V[i][j]) {
				V[i][j] -= age;
				L[i][j].set(target, age + 1);
				stop++;
			} else {
				v += age/2;
			}
		}
		L[i][j].subList(stop, L[i][j].size()).clear(); // ArrayList의 컷, 혹은 부분 삭제 방법 
		V[i][j] += v;
	}
	
	static void propagation(int i, int j) {
		int size = L[i][j].size();
		for (int target=0; target<size; target++) {
			int age = L[i][j].get(target);
			if (age % 5 == 0) {
				for (int k=0; k<xs.length; k++) {
					int ni = i + xs[k];
					int nj = j + ys[k];
					if (0<=ni && ni<N && 0<=nj && nj<N) {
						L[ni][nj].add(0, 1);
					}
				}
			}
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]); // A 배열 줄수 
		M = Integer.parseInt(tmp[1]); // 초기 나무의 갯수 
		K = Integer.parseInt(tmp[2]); // 경과 년수 
		
		A = new int[N][N];
		T = new int[M][3];
		for (int i=0; i<N; i++) A[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for (int i=0; i<M; i++) T[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		V = new int[N][N];
		L = new ArrayList[N][N];
		for (int i=0; i<N; i++) Arrays.fill(V[i], 5);
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				L[i][j] = new ArrayList<Integer>();
			}
		}
		
		for (int i=0; i<M; i++) {
			L[T[i][0]-1][T[i][1]-1].add(T[i][2]);
		}
		
		for (int i=0; i<K; i++) {
			spring();
			fall();
			winter();
		}
		
		int ret = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				ret += L[i][j].size();
			}
		}
		
		bw.write(Integer.toString(ret));
		bw.flush();
		
		br.close();
		bw.close();
	}
}
