package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42579

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
//import java.util.TreeMap;

// 참고 : http://ithub.tistory.com/34
// 참고 : http://huskdoll.tistory.com/5
// 참고(키 오름차순/내림차순) : http://seongsillvanas.tistory.com/7

public class Q42579 {
	public static void main(String args[]) {
		Q42579 q = new Q42579();
		String[] genres = {"classic", "pop", "classic"};
		int[] plays = {150, 2000, 150};
		q.solution(genres, plays);
	}
	
    public int[] solution(String[] genres, int[] plays) {
        HashMap<Object, Object> g = new HashMap<>();
        HashMap<Object, HashMap<Object, Object>> p = new HashMap<>();
        
        for (int i=0; i<genres.length; i++) g.put(genres[i], (int) g.getOrDefault(genres[i], 0) + plays[i]); // 구체적인 클래스 지정을 우회했기 때문에 명시적으로 캐스팅을 해야됨 
        for (int i=0; i<genres.length; i++) {
        	if (p.get(genres[i]) == null) p.put(genres[i], new HashMap<>());
            p.get(genres[i]).put(i, plays[i]);
        }
        Iterator<Object> it = sortByValue(g).iterator();
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(it.hasNext()) {
        	HashMap<Object, Object> t = p.get(it.next());
        	List<Object> list = sortByValue(t); // 여기서 같은 value라도 앞선 index가 별다른 조치를 취하지 않았더라도 앞에 온 이유는 key의 오름차순 정렬이 디폴트이기 때문으로 보인다. 
            for(int j=0; j<list.size() && j<2; j++) ans.add((Integer) list.get(j)); // 역시 명시적으로 캐스팅을 해줘야 한다. 
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
    
    List<Object> sortByValue(HashMap<Object, Object> map) { // object를 써서 구체적인 클래스 지정을 우회함. 
        List<Object> l = new ArrayList<Object>();
        l.addAll(map.keySet());
        
        Collections.sort(l, new Comparator<Object>() {
           public int compare(Object k1, Object k2) {
               Integer v1 = (Integer) map.get(k1);
               Integer v2 = (Integer) map.get(k2);
               return (int)v2 - (int)v1;
           } 
        });
        return l;
    }
}