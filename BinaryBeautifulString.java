package code;
/*
 * 
 * https://www.hackerrank.com/challenges/beautiful-binary-string
 * 
 * 
 */
public class BinaryBeautifulString {

	public static void main(String[] args) {
		String s = "0101010";

		char schars[] = s.toCharArray();
		int count = 0;
		for (int i = 0; i < s.length() - 2; i++) {
			String temp = s.substring(i, i + 3);
			if (temp.equals("010")) {
				count++;
				schars[i + 2] = '1';
				s = new String(schars);
			}

		}
		System.out.println(count);

	}

}
