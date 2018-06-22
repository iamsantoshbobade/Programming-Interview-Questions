package code;

public class ReducedString {

	public static void main(String[] args) {

		String s = "aa";
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				s = s.substring(0, i) + s.substring(i + 2);
				i = -1;
			}
		}
		if (s.length() != 0)
			System.out.println(s);
		else
			System.out.println("Empty String");

	}

}
