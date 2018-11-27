package baekjoon;

//https://www.acmicpc.net/problem/12871

import java.util.*;

public class Q12871_2 {
 public static void main(String args[]) {
     Scanner sc = new Scanner(System.in);
     String s = sc.nextLine();
     String t = sc.nextLine();
     for (int i=0; i<2500; i++) {
         if (s.charAt(i%s.length()) != t.charAt(i%t.length())) {
             System.out.println(0);
             System.exit(0);
         }
     }
     System.out.println(1);
     sc.close();
 }
}