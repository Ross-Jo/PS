package programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1016 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		long min = Long.parseLong(input[0]);
		long max = Long.parseLong(input[1]);
		boolean[] check = new boolean[(int) (max-min+1)];
		int counter = (int) (max-min+1);
		
		long end = (long) Math.sqrt(max);
		
		for (long i=2; i<=end; i++) {
			
			long square = i*i;
			
			if (square >= min && check[(int) (square-min)]) continue;
			
			long floor = min/square;
			
			long ceil = max/square;
			
			for (long j=floor; j<=ceil; j++) {
				long tmp = square * j;
				if((tmp >= min) && !check[(int) (tmp-min)]) {
					check[(int) (tmp-min)] = true;
					counter--;
				}
			}
			
		}
		
		bw.write(Integer.toString(counter));
		bw.flush();
		
		br.close();
		bw.close();
	}
}
