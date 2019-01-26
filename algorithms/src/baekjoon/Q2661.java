package baekjoon;

// https://www.acmicpc.net/problem/2661

import java.util.ArrayList;
import java.util.Scanner;

public class Q2661 {
	static int n;
	static ArrayList<Integer> ans;
	
	static void makeArray(ArrayList<Integer> arr, int index) throws Exception {
		if (check(arr)) return;
		if (index == n) {
			ans = arr;
			throw new Exception();
		}
		
		for (int e=1; e<=3; e++) {
			arr.add(index, e);
			makeArray(arr, index+1);
			arr.remove(index);
		}
	}
	
	static boolean check(ArrayList<Integer> arr) { // 중복 연속 배열 포함 여부
		int len = arr.size();
		for (int i=1; i<=len/2; i++) {
			for (int j=0; j<=len-i*2; j++) {
				int c = 0;
				for (int k=0; k<i; k++) {
					if (arr.get(j+k) == arr.get(j+k+i)) c++;
				}
				if (c==i) return true;
			}
		}
		
		return false;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		
		try {
			makeArray(arr, 0);
		} catch(Exception e) {
			for (int i: ans) System.out.print(i);
		}
		
		sc.close();
	}
}
