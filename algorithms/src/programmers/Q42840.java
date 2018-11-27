package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42840

import java.util.ArrayList;

public class Q42840 {
	public static void main(String args[]) {
		
	}
    int[] p1 = {1, 2, 3, 4, 5};
    int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    public int[] solution(int[] answers) {
        int[] counter = new int[3];
        int max = 0;
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i=0; i<answers.length; i++) {
            if(p1[i%p1.length] == answers[i]) counter[0]++;
            if(p2[i%p2.length] == answers[i]) counter[1]++;
            if(p3[i%p3.length] == answers[i]) counter[2]++;
            max = Math.max(max, Math.max(Math.max(counter[0], counter[1]), counter[2]));
        }
        for (int i=0; i<counter.length; i++) if(counter[i] == max) al.add(i+1);
        
        return al.stream().mapToInt(i->i).toArray();
    }
}