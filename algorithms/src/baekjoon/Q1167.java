package baekjoon;

//https://www.acmicpc.net/problem/1167

//cf) https://www.acmicpc.net/board/view/584

//여담으로 아무 점(v)에서 시작해서 가장 먼 점(v1)을 찾고, 그 점(v1)에서 가장 먼 점(v2)를 찾으면, v1과 v2 사이의 거리가 트리의 지름이됩니다. 
//다른 곳에도 응용되는 아이디어인 것 같더라구요.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1167 {
	
	static class Node {
		int index, weight;
		Node(int index, int weight) {
			this.index = index; this.weight = weight;
		}
	}
	
	static int V, ans = -1, farthest;
	static boolean[] gv;
	static ArrayList<ArrayList<Node>> g = new ArrayList<ArrayList<Node>>();
	
	static void findDia1() {
		gv = new boolean[V+1];
		findDia2(1, 0);
		
		gv = new boolean[V+1];
		findDia2(farthest, 0);
	}
	
	static void findDia2(int i, int length) {
		if (length > ans) {
			ans = length;
			farthest = i;
		}
		gv[i] = true;
		for (Node n: g.get(i)) if (!gv[n.index]) findDia2(n.index, length + n.weight);
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		for (int i=0; i<=V; i++) g.add(new ArrayList<Node>());
		
		StringTokenizer st;
		for (int i=0; i<V; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			while(true) {
				int val1 = Integer.parseInt(st.nextToken());
				if (val1 == -1) break;

				int val2 = Integer.parseInt(st.nextToken());
				g.get(t).add(new Node(val1, val2));
			}
		}
		
		findDia1();
		System.out.println(ans);
		
		br.close();
	}
}
