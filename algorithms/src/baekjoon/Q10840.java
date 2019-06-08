package baekjoon;

// https://www.acmicpc.net/problem/10840
// 참고 : https://justicehui.github.io/koi/2019/01/05/BOJ10840/
// 시간초과 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Q10840 {
	static ArrayList<Integer> prime = new ArrayList<>();
	static int mod = 524287;
	static int ans = 0;
	
	static class Pair {
		int hash, len;
		Pair(int hash, int len) {
			this.hash = hash; this.len = len;
		}
	}
	
	static ArrayList<Pair>[] HashTable = new ArrayList[mod]; // ArrayList 트릭
	
	static boolean isPrime(int n) {
		if (n < 2) return false;
		for (int i = 2; i * i <= n; i++) if ((n & 1) == 0) return false;
		return true;
	}
	
	static void getPrime() {
		for (int i=2; i<=10000; i++) if (isPrime(i)) prime.add(i);
	}
	
	static void solve(String a, String b) {
		for (int i=0; i<mod; i++) HashTable[i] = new ArrayList<Pair>();
		
		int x, y; // x : 첫번째 해시값, y : 두번째 해시값 
		for (int i=0; i<a.length(); i++) {
			x = y = 1;
			for (int j=i; j<a.length(); j++) { // 모든 구간에 대한 해시값을 구하기 위함
				int now = a.charAt(j) - 'a';
				int len = j - i + 1;
				x = (x * prime.get(now)) % mod; // 인덱스도 해싱을 통해 도출 
				y = (y * prime.get(now + 26)) % mod;
				ArrayList<Pair> bucket = HashTable[x];
				bucket.add(new Pair(y, len));
			}
		}
		
		for (int i=0; i<b.length(); i++) {
			x = y = 1;
			for (int j=i; j<b.length(); j++) {
				int now = b.charAt(j) - 'a';
				int len = j - i + 1;
				x = (x * prime.get(now)) % mod;
				y = (y * prime.get(now + 26)) % mod;
				for (int k = 0; k < HashTable[x].size(); k++) {
					Pair target = HashTable[x].get(k);
					if (target.hash == y && target.len == len) ans = Math.max(ans, len);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		getPrime();
		String a, b;
		a = br.readLine(); b = br.readLine();
		solve(a, b);
		
		bw.write(ans + " ");
		bw.newLine();
		bw.flush();
		
		br.close();
		bw.close();
	}
}
