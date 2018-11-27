package baekjoon;

// https://www.acmicpc.net/problem/1874

import java.util.ArrayList;
//import java.util.Scanner;
import java.util.Stack;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

//인풋 아웃풋 방식 바꿔서 속도차이 보기 -> 1300ms 정도 속도 증가

public class Q1874 {
	public static void main(String args[]) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Integer> s = new Stack<Integer>();
		ArrayList<String> al = new ArrayList<String>();
		
		int n = Integer.parseInt(br.readLine());
		int number = 1;
		boolean flag = true;
		
		while(n-- > 0) {
			int target = Integer.parseInt(br.readLine());
			
			if(s.contains(target)) {
				if(s.peek() == target) {
					s.pop();
					al.add("-");
				} else {
//					System.out.println("NO");
					bw.write("NO");
					bw.newLine();
					bw.flush();
					flag = false;
					break;
				}
			} else {
				while(number <= target) {
					s.push(number++);
					
					al.add("+");
				}
				s.pop();
				al.add("-");
			}
		}
		
		if(flag) {
			for(String el: al) {
//				System.out.println(el);
				bw.write(el);
				bw.newLine();
			}
			bw.flush();
		}
		
//		sc.close();
		bw.close();
		br.close();
	}
}

//아래는 배울만한 코드 
///**
//* Date: 2018. 10. 3.
//* Author: inhyuck | https://github.com/inhyuck
//* Solution URL: https://github.com/inhyuck/algorithm
//* Title: 스택 수열
//* description: 스택으로 수열 만들기 (링크 참조)
//* Problem URL: https://www.acmicpc.net/problem/1874
//*/
////package io.inhyuck.collections;
//
//import java.io.*;
//import java.util.Stack;
//
//public class Main {
//  public static void main(String[] args) throws IOException {
//      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//      int n = Integer.parseInt(reader.readLine());
//      int[] numberList = new int[n];
//      for (int i = 0; i < n; i++) {
//          numberList[i] = Integer.parseInt(reader.readLine());
//      }
//      StringBuilder builder = new StringBuilder(); // 스트링 빌더를 써서 쓰는 시간을 줄인 것 
//      Stack<Integer> stack = new Stack<>();
//      int number, k = 0;
//      for (int i = 0; i < n; i++) {
//          number = numberList[i];
//          if (k < number) {
//              for (int j = k + 1; j <= number; j++) {
//                  stack.push(j);
//                  builder.append("+\n");
//                  k = j;
//              }
//          }
//          if (number != stack.pop()) { // 조건문을 확인할 때 이와 같은 확인 과정을 거치면서 자연스럽게 pop연산을 한 것 
//              System.out.println("NO");
//              return; // main 종료 
//          }
//          builder.append("-\n");
//      }
//      System.out.println(builder);
//  }
//}
