package code;

import java.io.IOException;

public class MakePalindrome {

	static void mystery(String[] letter) {
		for (int i = 0; i < letter.length; i++) {
			int letterLengh = letter[i].length();
			String currentLetter = letter[i];
			int startIndex = 0;
			int minConversions = 0;
			if (letterLengh % 2 == 0) {
				startIndex = letterLengh / 2;
			} else {
				startIndex = (letterLengh / 2);// + 1;
			}
			for (int j = 0; j < startIndex; j++) {
				int temp = currentLetter.charAt(letterLengh - j - 1) - currentLetter.charAt(j);
				if(temp < 0){
					temp *= -1;
				}
				minConversions += temp;

			}
			System.out.println(minConversions);

		}

	}

	public static void main(String[] args) throws IOException {
		String arr[] = { "abc", "abcba", "abcd", "abcaa" , "abcdedcbz"};
		mystery(arr);

	}

}
