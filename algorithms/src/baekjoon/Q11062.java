package baekjoon;

// https://www.acmicpc.net/problem/11062
// 시간 초과 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class Q11062 {
	static int n;
	static int[] nums;
	static int max;
	
	static void solve(int left, int right, int kTurn, int k, int count) {
		if (count == n) {
			if (max < k) max = k;
		}
		
		if (left-1>=0 && right+1 < n) { // 양쪽으로 확장 가능 
			if (nums[left-1] > nums[right+1]) {
				left -= 1;
				caller(left, right, kTurn, k, nums[left], count);
				
			} else if (nums[left-1] == nums[right+1]) {				
				left -= 1;
				caller(left, right, kTurn, k, nums[left], count);
				
				left += 1;
				
				right += 1;
				caller(left, right, kTurn, k, nums[right], count);
				
				return;
			} else {
				right += 1;
				caller(left, right, kTurn, k, nums[right], count);
			}
		} else if (left-1>=0 && right+1 >=n) { // 왼쪽으로만 확장 가능 
			left -= 1;
			caller(left, right, kTurn, k, nums[left], count);
		} else if (left-1<0 && right+1 <n) { // 오른쪽으로만 확장 가능 
			right += 1;
			caller(left, right, kTurn, k, nums[right], count);
		}
	}
	
	public static void caller(int left, int right, int kTurn, int k, int value, int count) {
		System.out.println("k: "+ k);
		if (kTurn==1) solve(left, right, 0, k+value, count+1);
		else solve(left, right, 1, k, count+1);
		
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		while (T-->0) {
			n = Integer.parseInt(br.readLine());
			nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			max = -1;
			
			for (int i=0; i<n; i++) {
				if (n%2==1) {
					solve(i, i, 0, nums[i], 1);
				} else {
					solve(i, i, 1, 0, 1);
				}
			}
			
			bw.write(Integer.toString(max));
			bw.newLine();
			bw.flush();
		}
		
		bw.close();
		br.close();
	}
}
