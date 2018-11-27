package baekjoon;

// https://www.acmicpc.net/problem/2178

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {
	
	static class graphNode {
		int name;
		int numOfPointers;
		int color; // BFS를 하기 위한 변수
		int distance; // BFS를 하기 위한 변수
		graphNode parent; // BFS를 하기 위한 변수
		graphNode[] pointers;

		public graphNode(int name) {
			this.name = name;
			this.numOfPointers = 0;
			pointers = new graphNode[4];
		}

		public void genNextNode(int name) {
			this.pointers[numOfPointers] = new graphNode(name);
			numOfPointers++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = null;

		// input 읽어들이기
		line = sc.nextLine();
		StringTokenizer st = new StringTokenizer(line, " ");

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		int[][] matrix = new int[row][col];
		int node = 0;

		for (int i = 0; i < row; i++) {
			line = sc.nextLine();
			for (int j = 0; j < col; j++) {
				matrix[i][j] = line.charAt(j) - 48; // 이렇게 해석을 하면 아스키 코드 값이기 때문에 48을 제해 줘야 함.
				if (line.charAt(j) - 48 == 1)
					node++;
			}
		}

		// 받아들인 input을 기반으로 그래프 생성하기. graphNode를 활용함
		graphNode[] gnArray = new graphNode[node];
		int counter = 0; // graphNode 생성의 카운팅을 위함
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					gnArray[counter] = new graphNode(i * 100 + j); // input으로 주어지는 row 및 col이 최대 100이라는 점에 착안하여 노드 네이밍
					if ((i + 1) < row) { // null_pointer에러를 방지하기 위함. 노드간 연결을 표현해 주기 위하여 사용
						if (matrix[i + 1][j] == 1) {
							gnArray[counter].genNextNode((i + 1) * 100 + j);
						}
					}
					if ((j + 1) < col) {
						if (matrix[i][j + 1] == 1) {
							gnArray[counter].genNextNode((i) * 100 + j + 1);
						}
					}
					if ((i - 1) >= 0) {
						if (matrix[i - 1][j] == 1) {
							gnArray[counter].genNextNode((i - 1) * 100 + j);
						}
					}
					if ((j - 1) >= 0) {
						if (matrix[i][j - 1] == 1) {
							gnArray[counter].genNextNode((i) * 100 + j - 1);
						}
					}
					counter++;
				}
			}
		}

//		//그래프 확인을 위한 출력 부분
//		for(int i=0;i<node;i++){
//			System.out.print("[노드이름] "+gnArray[i].name+": ");
//			for(int j=0;j<4;j++){
//				if(gnArray[i].pointers[j]!=null){
//					System.out.print(j+"번 "+gnArray[i].pointers[j].name+"-> ");
//				}
//			}
//			System.out.println();
//		}

		// BFS 탐색 : 0-white, 1-gray, 2-black
		for (int i = 1; i < node; i++) {
			gnArray[i].color = 0;
			gnArray[i].distance = Integer.MAX_VALUE;
			gnArray[i].parent = null;
		}
		gnArray[0].color = 1;
		gnArray[0].distance = 1;
		gnArray[0].parent = null;

		Queue<graphNode> queue = new LinkedList<graphNode>(); // 큐 사용법
		queue.add(gnArray[0]);

		while (queue.isEmpty() != true) {
			graphNode targetNode = queue.poll();
			for (int j = 0; j < targetNode.pointers.length; j++) { // 자료구조를 고쳐서 수정하기. for문 2번 if문 3번 중복으로 인해 비효율
				for (int i = 0; i < node; i++) {
					if (targetNode.pointers[j] != null) {
						if (targetNode.pointers[j].name == gnArray[i].name) {
							if (gnArray[i].color == 0) {
								gnArray[i].color = 1;
								gnArray[i].distance = targetNode.distance + 1;
								gnArray[i].parent = targetNode;
								queue.add(gnArray[i]);
							}
						}
					}
				}
				targetNode.color = 2;
			}
		}

		System.out.println(gnArray[node - 1].distance);

		sc.close();
	}
}