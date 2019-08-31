package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Q42890 {
	static String[][] db;
	static ArrayList<Integer> ans;
	static int row, col;
	
	static boolean unique(int set) {
		Set<String> bucket = new HashSet<>();
		boolean[] check = new boolean[col];
		for (int j=0; j<col; j++) {
			if ((set & (1<<j)) != 0) check[j] = true;
		}
		
		for (int i=0; i<row; i++) {
			String key = "";
			for (int j=0; j<col; j++) if (check[j]) key += db[i][j];
			bucket.add(key);
		}
		
		return bucket.size() == row ? true : false;
	}
	
	static int solution(String[][] relation) {
		db = relation;
		ans = new ArrayList<>();
		
		row = relation.length;
		col = relation[0].length;
		
		boolean go = true;
		for (int i=0; i<(1<<col); i++) {
			go = true;
			for (int e: ans) if ((i & e) == e) go = false;
			if (go && unique(i)) ans.add(i);
		}
		return ans.size();
	}

	public static void main(String[] args) {
		String[][] input = {	
								{"100","ryan","music","2"},
								{"200","apeach","math","2"},
								{"300","tube","computer","3"},
								{"400","con","computer","4"},
								{"500","muzi","music","3"},
								{"600","apeach","music","2"}
						   };
		System.out.println(solution(input));
	}
}
