package baekjoon;

// https://www.acmicpc.net/problem/1325
// 역시 실패 

import java.util.Scanner;
import java.util.StringTokenizer;
//import java.util.Queue;
//import java.util.LinkedList;
import java.util.ArrayList;

class node {
	int nodeNum = 0;
	int sumOfIncomingEdge = 0;

	node(int nodeNum, int sumOfIncomingEdge) {
		this.nodeNum = nodeNum;
		this.sumOfIncomingEdge = sumOfIncomingEdge;
	}
}

// 유향 그래프 생성을 위한 클래스
class adjency_list { // class 생성에 대한 컨벤션 유의할 것 (다음부터는 함수와 컨벤션 확실히 구분하기)
	static int nV; // 총 vertex 갯수
	static int nE; // 총 edge 갯수
	static ArrayList<ArrayList<node>> graph;
	static node[] nodeArray;
	int max = Integer.MIN_VALUE;

	public node[] createGraph(int[][] matrix, int N, int M) {
		nV = N;
		nE = M;
		graph = new ArrayList<ArrayList<node>>(); // ArrayList를 사용하기 위한 import문 필요, 인접 리스트 초기화

		nodeArray = new node[N + 1];
		for (int i = 0; i < N + 1; i++) {
			nodeArray[i] = new node(i, 0); // node 배열 초기화
		}

		for (int i = 0; i < nV + 1; i++) { // graph에 담을 arraylist 초기화
			graph.add(new ArrayList<node>());
		}

		int V1, V2;
		for (int i = 0; i < nE; i++) {
			V1 = matrix[i][0];
			V2 = matrix[i][1];
			nodeArray[V2].sumOfIncomingEdge += 1;
			graph.get(V1).add(nodeArray[V2]);
		}

		return nodeArray;
	}

	public void createGraph(int[][] matrix, int N, int M, node[] nodeArray) {
		nV = N;
		nE = M;
		graph = new ArrayList<ArrayList<node>>(); // ArrayList를 사용하기 위한 import문 필요, 인접 리스트 초기화

		for (int i = 0; i < nV + 1; i++) { // graph에 담을 arraylist 초기화
			graph.add(new ArrayList<node>());
		}

		int V1, V2;
		for (int i = 0; i < nE; i++) {
			V1 = matrix[i][0];
			V2 = matrix[i][1];
			nodeArray[V2].sumOfIncomingEdge += nodeArray[V1].sumOfIncomingEdge;
			if (max < nodeArray[V2].sumOfIncomingEdge)
				max = nodeArray[V2].sumOfIncomingEdge;
			graph.get(V1).add(nodeArray[V2]);
		}
	}

	public ArrayList<ArrayList<node>> getGraph() {
		return graph;
	}

	public node[] getNodes() {
		return nodeArray;
	}

	public int getMax() {
		return max;
	}

	public void printGraph() {
		for (int i = 1; i < graph.size(); i++) {
			System.out.print("노드이름[" + i + "]: ");
			for (int j = 0; j < graph.get(i).size(); j++) {
				System.out.print(graph.get(i).get(j).nodeNum + "/" + graph.get(i).get(j).sumOfIncomingEdge + "->");
			}
			System.out.println();
		}
	}
}

public class Q1325_2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String line = null;

		line = sc.nextLine();
		StringTokenizer st = new StringTokenizer(line, " ");

		int N = Integer.parseInt(st.nextToken()); // num of computer
		int M = Integer.parseInt(st.nextToken());
		int[][] matrix = new int[M][2];

		for (int i = 0; i < M; i++) {
			line = sc.nextLine();
			st = new StringTokenizer(line, " ");
			for (int j = 0; j < 2; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		adjency_list al = new adjency_list();
		al.createGraph(matrix, N, M, al.createGraph(matrix, N, M));
		al.printGraph();

		int max = al.getMax();
		node[] nodes = al.getNodes();
		for (int i = 1; i < N + 1; i++) {
			if (nodes[i].sumOfIncomingEdge == max)
				System.out.print(nodes[i].nodeNum + " ");
		}

		sc.close();
	}
}