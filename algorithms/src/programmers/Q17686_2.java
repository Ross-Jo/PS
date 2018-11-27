package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/17686

public class Q17686_2 {
	static class File {
		String head;
		int number;
		String tail;
		
		File(String head, int number, String tail) {
			this.head = head;
			this.number = number;
			this.tail = tail;
		}
	}
	
	public static void main(String args[]) {
//		String[] input = {
//			"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"
//		};
		
//		String[] input = {
//				"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"
//		};
		
		String[] input = {
				"b.01.jpg", "b1.jpg", "b001.jpg", "b2.jpg", "C1.jpg", "A1.jpg", "b..01.jpg", "b.-01.jpg",  "a01.jpg", "A10.png", "A01.png",
				"z 0.jpng", "zza01.png", "az3.jpng"
		};
		
		String[] ans = mergeSort(input);
		
		for (String element: ans) {
			System.out.println(element + " ");
		}
		
	}
	
	public static String[] mergeSort(String[] input) {
		String[] tmp = new String[input.length];
		doSort(input, tmp, 0, input.length - 1);
		return input;
	}
	
	public static void doSort(String[] input, String[] tmp, int front, int rear) {
		if (front < rear) {
			int middle = front + (rear - front) / 2;
			doSort(input, tmp, front, middle);
			doSort(input, tmp, middle + 1, rear);
			merge(input, tmp, front, middle, rear);
		}
	}
	
	public static void merge(String[] input, String[] tmp, int front, int middle, int rear) {
		System.arraycopy(input, front, tmp, front, rear - front + 1);
		
		int i = front;
		int j = middle + 1;
		int k = front;
		
		while (i <= middle && j<= rear) {
			
			File i_file = divider(tmp[i]);
			File j_file = divider(tmp[j]);
			
			if (i_file.head.compareTo(j_file.head) < 0) {
				input[k] = tmp[i];
				i++;
			} else if (i_file.head.compareTo(j_file.head) == 0) {
				
				if (i_file.number <= j_file.number) {
					input[k] = tmp[i];
					i++;
				} else {
					input[k] = tmp[j];
					j++;
				}
				
			} else {
				input[k] = tmp[j];
				j++;
			}
			k++;
		}
		
		while (i <= middle) {
			input[k] = tmp[i];
			i++;
			k++;
		}
		
		while (j <= rear) {
			input[k] = tmp[j];
			j++;
			k++;
		}
	}
	
	// 나누는 부분이 문제
	public static File divider(String file) {
		
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
		
		while (j<file.length() && file.charAt(j) >= '0' && file.charAt(j) <= '9') { // 인덱스가 밖으로 튀어나가는 상황에 대한 에러처리를 잘하
			tmp += Character.toString(file.charAt(j));
			j++;
		}
		
		number = Integer.parseInt(tmp);
		file = file.substring(j);
		tail = file;
		
		System.out.println(head + " " + number + " " + tail);
		
		return new File(head, number, tail);
	}
}
