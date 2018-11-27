package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/17682

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.stream.IntStream;

// 참고: https://stackoverflow.com/questions/4416425/how-to-split-string-with-some-separator-but-without-removing-that-separator-in-j/4416576
// char -> int 시 활용 함수 : Character.getNumericValue()
// char -> int 시 변경 가능한 다른 방법 : char - '0'

public class Q17682 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String score = sc.nextLine();
		
        Pattern p = Pattern.compile("[0-9]{1,2}[SDT]{1}[*#]{0,1}");
        Matcher m = p.matcher(score);
        String[][] eachRound = new String[3][3];
        int[] calcedVal = new int[3];
        int i = 0;
        
        // 참고: https://stackoverflow.com/questions/2973436/regex-lookahead-lookbehind-and-atomic-groups
        while(m.find())
        {
        	eachRound[0][i] = m.group();
        	
        	String[] splitted = eachRound[0][i].split("(?=[SDT])"); // lookaround regex
        	eachRound[1][i] = splitted[0];
			eachRound[2][i] = splitted[1];

        	int power = 1;
        	
        	switch (eachRound[2][i].charAt(0)) {
        		case 'S':
        			power = 1;
        			break;
        		case 'D': 
        			power = 2;
        			break;
        		case 'T': 
        			power = 3;
        			break;
        	}
        	
        	calcedVal[i] = (int)Math.pow(Integer.parseInt(eachRound[1][i]), power);
        	i++;
        }
        
        for (int j=0; j<3; j++) {
        	try {
        		if (eachRound[2][j].charAt(1) == '*') {
        			
        			calcedVal[j] *= 2;
        			if (j != 0) calcedVal[j-1] *= 2;
        			
            	} else if (eachRound[2][j].charAt(1) == '#') {
            		
            		calcedVal[j] *= -1;
            		
            	}
        	} catch (IndexOutOfBoundsException e) {
        		// void
        	}
        }
        
        System.out.println(IntStream.of(calcedVal).sum());
		sc.close();
	}
}