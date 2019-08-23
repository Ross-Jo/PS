package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Q42888_2 {
    static String[] solution(String[] record) {
    	ArrayList<String> ans = new ArrayList<>();
        String[][] command = new String[2][record.length]; 
        Map<String, String> map = new HashMap<>();
        
        for (int i=0; i<record.length; i++) {
        	String[] input = record[i].split(" ");
        	if (input[0].equals("Enter") || input[0].equals("Change")) map.put(input[1], input[2]);
        	command[0][i] = input[0];
        	command[1][i] = input[1];
        }
        
        for (int i=0; i<command[0].length; i++) {
        	if (command[0][i].equals("Enter")) {
        		ans.add(map.get(command[1][i]) + "님이 들어왔습니다.");
        	} else if (command[0][i].equals("Leave")) {
        		ans.add(map.get(command[1][i]) + "님이 나갔습니다.");
        	}
        }
        
        return ans.toArray(new String[0]);
    }
	
	public static void main(String[] args) {
		String[] data = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		for (String ret: solution(data)) System.out.println(ret);
	}
}
