package baekjoon;

// https://www.acmicpc.net/problem/5430

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
//import java.util.Collections;

public class Q5430 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		// 참고 : https://stackoverflow.com/questions/880581/how-to-convert-int-to-integer-in-java int[] 배열 전
		// 참고(정규식): http://blog.daum.net/feelsogreat/83
		while(T-->0) {
			String p = compaction(br.readLine());
//			System.out.println("컴팩션은잘되고 있는가?: "+p);
			ArrayList<Integer> al = new ArrayList<Integer>(100); // 링크드리스트 쓰면 성능 더 개선시킬 수 있을 것으로 보임
			int n = Integer.parseInt(br.readLine());
			boolean isError = false;
			boolean reversed = false;
			
			if (n >= 1) {
				al.addAll(Arrays.stream(br.readLine().replace("[", "").replace("]", "").split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList())); // int[] 배열 -> ArrayList<Integer> 배열 
			} else {
				br.readLine();
			}
			
			for (char c: p.toCharArray()) {
				if(c=='R') {
					reversed = !reversed;
//					Collections.reverse(arrayList);
				} else {
					if (al.isEmpty()) {
						System.out.println("error");
						isError = true;
						break;
					} else {
						if (reversed) {
							al.remove(al.size()-1);
						} else {
							al.remove(0);
						}
					}
				}
			}
			
			if (!isError && reversed) {
				StringBuilder sb = new StringBuilder(); 
				sb.append("[");
				for(int i=al.size()-1; i>=0; i--) {
					if(i!=0) {
						sb.append(al.get(i));
						sb.append(",");
					} else {
						sb.append(al.get(i));
					}
				}
				sb.append("]");
				System.out.println(sb.toString());
			}
			
			if (!isError && !reversed) {
				StringBuilder sb = new StringBuilder(); 
				sb.append("[");
				for(int i=0; i<al.size(); i++) {
					if(i!=al.size()-1) {
						sb.append(al.get(i));
						sb.append(",");
					} else {
						sb.append(al.get(i));
					}
				}
				sb.append("]");
				System.out.println(sb.toString());
			}
			

		}
		
		br.close();
	}
	
	static String compaction(String p) {
		int rcount = 0;
		StringBuilder sb = new StringBuilder();
		for(char c: p.toCharArray()) {
			if(c=='D') {
				if(rcount % 2 == 1) {
					sb.append('R');
					rcount = 0;
				}
				sb.append(c);
			} else {
				rcount++;
			}
		}
		
		if(rcount % 2 == 1) {
			sb.append('R');
		}
		
		return sb.toString();
	}
	
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    public static void main(String[] args) throws IOException {
//        StringBuilder sb = new StringBuilder();
//
//        int testCase = Integer.parseInt(br.readLine());
//
//        while(testCase-- > 0)
//            sb.append(solve()).append('\n');
//
//        System.out.println(sb.toString());
//    }
//
//
//    private static String solve() throws IOException {
//        Deque<String> deque = new LinkedList<>();
//        boolean isFront = true;
//        String cmds = br.readLine();
//        int num = Integer.parseInt(br.readLine());
//        String nums = br.readLine();
//        if(nums.length() > 2)
//            nums = nums.substring(1, nums.length() - 1);
//        else
//            nums = "";
//
//        if(! nums.isEmpty()) {
//            String[] inputs = nums.split(",");
//
//            for (String input : inputs)
//                deque.addLast(input);
//        }
//
//        for(char cmd : cmds.toCharArray()) {
//            switch(cmd) {
//                case 'R':
//                    isFront = !isFront;
//                    break;
//                case 'D':
//                    if(deque.isEmpty())
//                        return "error";
//
//                    if (isFront) {
//                        deque.pollFirst();
//                    } else {
//                        deque.pollLast();
//                    }
//                    break;
//            }
//        }
//        if(deque.isEmpty())
//            return "[]";
//        
//        StringBuilder sb = new StringBuilder("[");
//        if(isFront) {
//            while(!deque.isEmpty())
//                sb.append(deque.pollFirst()).append(",");
//        } else {
//            while(!deque.isEmpty())
//                sb.append(deque.pollLast()).append(",");
//        }
//
//        return sb.replace(sb.length() - 1, sb.length(), "]").toString();
//    }
//}