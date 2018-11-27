package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42888

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Q42888 {
	public static void main(String args[]) {
		Q42888 q = new Q42888();
		q.solution(new String[] {
				"Enter uid1234 Muzi", 
				"Enter uid4567 Prodo", 
				"Leave uid1234", 
				"Enter uid1234 Prodo", 
				"Change uid4567 Ryan"});
	}
	public String[] solution(String[] record) {
		
		String[][] logs = new String[record.length][3];
		ArrayList<String> ret = new ArrayList<String>();
		Map<String, String> match = new HashMap<>();
		
		for (int i=0; i<record.length; i++) {
			String[] log = record[i].split(" ");
			for (int j=0; j<log.length; j++) {
				logs[i][j] = log[j];
				
				if (log[0].equals("Enter") || log[0].equals("Change")) {
					match.put(log[1], log[2]);
				}
			}
		}
		
		for (int i=0; i<logs.length; i++) {
			if (logs[i][0].equals("Enter")) {
				ret.add(String.format("%s님이 들어왔습니다.", match.get(logs[i][1])));
			} else if (logs[i][0].equals("Leave")) {
				ret.add(String.format("%s님이 나갔습니다.", match.get(logs[i][1])));
			}
		}
		
		return ret.toArray(new String[0]);
	}
}