package code;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class UniquePalindromes {

	static int palindrome(String str) {
		int wordLength = 1;
		Set<String> uniqueArray = new HashSet<String>();

		for (int i = str.length(); i >= 1; i--) {
			for (int j = 0; j <= str.length() - wordLength; j++) {
				String temp = str.substring(j, j + wordLength);
				if (isPalindrome(temp)) {
					uniqueArray.add(temp); //Add only unique strings
				}
			}

			wordLength++; //Increase word frame by one after every iteration
		}

		return uniqueArray.size();

	}

	static boolean isPalindrome(String a) {
		StringBuffer str1 = new StringBuffer(a).reverse();
		return a.equals(str1.toString());

	}

	public static void main(String[] args) throws IOException {
		System.out.println(palindrome("aabaa"));

	}

}
