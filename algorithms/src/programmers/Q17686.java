package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/17686

import java.util.Arrays;
import java.util.Comparator;

class File {
	int index;
	String head;
	int number;
	String tail;
	
	File(int index, String head, int number, String tail) {
		this.index = index;
		this.head = head;
		this.number = number;
		this.tail = tail;
	}
}

class Comp implements Comparator<File> { // 비교기준이 2개 이상인 경우 비교의 방법
    @Override
    public int compare(File file1, File file2) {
		int ret = 0;
		
		if (!file1.head.equals(file2.head)) {
			ret = file1.head.compareTo(file2.head);
		}
		
		if (ret == 0) {
			if (file1.number < file2.number) {
				ret = -1;
			}
		}
		
        return ret;
    }
}

public class Q17686 {
	public static void main(String[] args) {
		
//		String[] input = {
//			"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"
//		};
		
//		String[] input = {
//			"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"
//		};
		
		String[] input = {
				"apple101.png", "banana202.jpg", "tu- .rtle01.png", " -turtle02.png", "turtle002.png", "turtle0000.png", "Turtle0001.png", "cash333.api"
		};
		
		File[] files = new File[input.length];
		
		for (int i=0; i<input.length; i++) {
			files[i] = divider(i, input[i]);
		}
		
		Arrays.sort(files, new Comp()); // 자바의 경우 안정정렬을 지원하지 않는다. 
		
		for (File file: files) {
			System.out.println(input[file.index]);
		}
	}
	
	public static File divider(int index, String file) {
		
		file = file.toLowerCase();
		
		String head = "";
		String tmp = "";
		int number = 0;
		String tail = "";
		
		int j=0;
		
		while (file.charAt(j) >= 'a' && file.charAt(j) <= 'z' || file.charAt(j) == ' ' || file.charAt(j) == '-' || file.charAt(j) == '.') {
			head += Character.toString(file.charAt(j));
			j++;
		}
		
		file = file.substring(j);
		
		j=0;
		
		while (file.charAt(j) >= '0' && file.charAt(j) <= '9') {
			tmp += Character.toString(file.charAt(j));
			j++;
		}
		
		number = Integer.parseInt(tmp);
		file = file.substring(j);
		tail = file;
		
		return new File(index, head, number, tail);
	}
	
}