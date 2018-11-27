package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/17683

public class Q17683 {
	public static void main(String[] args) {
		
//		String m = "ABCDEFG"; // 1<=m<=1439
//		String[] musicinfos = { // 100곡 이하의 정보
//			"12:00,12:14,HELLO,CDEFGAB", 
//			"13:00,13:05,WORLD,ABCDEF"
//		};
		
//		String m = "CC#BCC#BCC#BCC#B";
//		String[] musicinfos = {
//			"03:00,03:30,FOO,CC#B", 
//			"04:00,04:08,BAR,CC#BCC#BCC#B"
//		};
		
		String m = "ABC";
		String[] musicinfos = {
			"12:00,12:14,HELLO,C#DEFGAB",
			"13:00,13:05,WORLD,ABCDEF"
		};
		
		String ans = "(None)";
		String[][] data = new String[musicinfos.length][6];
		int i=0;
		int longest=0;
		
		m = translator(m);
		
		for (String music: musicinfos) {
			String[] eachData = music.split(",");
			data[i][0] = eachData[0]; // 시작시간 
			data[i][1] = eachData[1]; // 종료시간 
			data[i][2] = eachData[2]; // 곡 제목 
			data[i][3] = translator(eachData[3]); // 악보 정보 
			data[i][4] = timeLaps(eachData[0], eachData[1]); // 재생시간
			
			String song = "";
			for (int j=0; j<Integer.parseInt(data[i][4]); j++) {
					song += data[i][3].charAt(j % data[i][3].length());
			}
			
			data[i][5] = song; // 재생정보 
			
			if (song.contains(m) && longest < Integer.parseInt(data[i][4])) {
				ans = data[i][2];
				longest = Integer.parseInt(data[i][4]);
			}
			i++;
		}
		
		System.out.println(ans);
	}
	
	public static String timeLaps(String start, String end) {
		String[] s_info = start.split(":");
		String[] e_info = end.split(":");
		
		int endInMiniute = Integer.parseInt(e_info[0]) * 60 + Integer.parseInt(e_info[1]);
		int startInMiniute = Integer.parseInt(s_info[0]) * 60 + Integer.parseInt(s_info[1]);
		
		return Integer.toString(endInMiniute - startInMiniute);
	}
	
	public static String translator(String mellody) {
		String ret = "";
		for (int i=0; i<mellody.length(); i++) {
			switch (mellody.charAt(i)) {
				case 'C':
					ret += 1;
					break;
				case 'D':
					ret += 3;
					break;
				case 'E':
					ret += 5;
					break;
				case 'F':
					ret += 7;
					break;
				case 'G':
					ret += 9;
					break;
				case 'A':
					ret += 'b';
					break;
				case 'B':
					ret += 'd';
					break;
				case '#':
					char target = ret.charAt(ret.length()-1);
					ret = ret.substring(0, ret.length()-1);
					ret += (char)(target + 1);
					break;
			}
		}
		
		return ret;
	}
}