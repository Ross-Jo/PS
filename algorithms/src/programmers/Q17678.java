package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/17678

import java.util.Arrays;

// set 자료구조에 대해서 알아볼 것
// hashmap, map 자료구조에 대해서 알아볼 것
// vector 자료구조에 대해서 알아볼 것
// B 및 B+ 트리에 대해서 알아볼 것, ajax에 대해서 알아볼 것
// mvc패턴에 대해서 더 알아볼 것
// 이진탐색트리에 대해서 더 알아볼 것, 완전이진트리에 대해서도 알아볼 것
// 전위, 중위, 후위순위에 대하여 더 공부할것 (위의 것들과 연관지어서)
// 해시자료구조에 대해서 알아볼 것
// 큐자료구조 및 각종 소팅에 대한 복습 및 시간복잡도 복습할 것 
// TCP/IP 커넥션 복습
// 트라이 자료구조 복습
// 자바의 clone에 대해서 알아볼 것
// 자바의 stringBuilder에 대해서 알아볼 것, stringBuffer와의 차이점은? 
// dp, dfs, bfs 복습할 것
// 우선순위 큐 다시 복습하기
// 파라메트릭 서치
// 이분매칭 복습하기

public class Q17678 {
	public static void main(String[] args) {
		int n = 2; // 셔틀운행 횟수
		int t = 10; // 셔틀운행 간격
		int m = 2; // 한 셔틀에 탈 수 있는 최대 크루
		
//		String[] timetable = {"08:00", "08:01", "08:02", "08:03"};
//		String[] timetable = {"09:10", "09:09", "08:00"};
//		String[] timetable = {"09:00", "09:00", "09:00", "09:00"};
//		String[] timetable = {"00:01", "00:01", "00:01", "00:01", "00:01"};
//		String[] timetable = {"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", 
//							  "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59" };
		String[] timetable = {"09:00", "09:00", "08:59", "08:59", "08:59"};

		
		int[] timetableInMin = new int[timetable.length];
		int startTimeInMin = 9 * 60;
		int lastBusArriveTime = startTimeInMin + (n-1) * t;
		int lastValidPepTime = -1;
		
		int ret = 0;

		for (int i=0; i<timetable.length; i++) {
			int translatedTime = translate(timetable[i]);
			timetableInMin[i] = translatedTime > lastBusArriveTime ? -1 : translatedTime;
		}
		
		Arrays.sort(timetableInMin);
		
		for (int i=0; i<n; i++) {
			int busPep = 0;
			
			if (i == n-1) {
				
				for (int j=0; j<timetableInMin.length; j++) {
					if (timetableInMin[j] != -1) {
						if (timetableInMin[j] > lastValidPepTime && busPep < m) {
							lastValidPepTime = timetableInMin[j];
						}
						if (busPep < m) {
							busPep++;
						}
						
					}
				}
				
				if (lastValidPepTime != -1) {
					ret = lastValidPepTime - 1;
					
					if (lastValidPepTime <= lastBusArriveTime && busPep < m) {
						ret = lastBusArriveTime;
					}
				} else {
					ret = lastBusArriveTime;
				}

				
				break;
			}
			
			for (int j=0; j<timetableInMin.length; j++) {
				if ((timetableInMin[j] != -1) && (timetableInMin[j] <= startTimeInMin + t * i) && busPep < m) {
					timetableInMin[j] = -1;
					busPep++;
				}
			}
		}
		
		// 참고: http://mwultong.blogspot.com/2007/01/java-0-leading-zero-to-number.html
//	    String hour = String.format("%02d", ret/60);
//	    String minute = String.format("%02d", ret%60);
//		System.out.println(hour + ":" + minute);
		
		System.out.println(String.format("%02d:%02d", ret/60, ret%60));
	}
	
	public static int translate(String time) {
		String[] splittedTime = time.split(":");
		
		int hour = Integer.parseInt(splittedTime[0]);
		int minute = Integer.parseInt(splittedTime[1]);
		
		return hour * 60 + minute;
	}
}