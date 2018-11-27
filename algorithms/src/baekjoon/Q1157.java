package baekjoon;

// https://www.acmicpc.net/problem/1157

import java.util.Scanner;

public class Q1157 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine().toLowerCase();
		
		int[] alphabet = new int[26];
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < word.length(); i++) {
			alphabet[word.charAt(i)-97]++;
			if(max<=alphabet[word.charAt(i)-97]) max = alphabet[word.charAt(i)-97];
		}
		
		int count = 0;
		int index = -1;
		for(int i=0; i<alphabet.length; i++){
			if(alphabet[i]==max) {
				count++;
				index = i;
			}
		}
		
		if(count==1){
			System.out.println((char)(index+65));
		}
		else{
			System.out.println("?");
		}
		
		sc.close();
		
	}
}