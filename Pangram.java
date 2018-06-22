package code;

public class Pangram {
	public static void main(String[] args) {
		String s = "We promptly judged antique ivory buckles for the next prize";

		int count[] = new int[26];
		s = s.toUpperCase();

		for (int i = 0; i < s.length(); i++) {

			if ( s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				count[s.charAt(i) - 65]++;
			}
		}
		for (int i = 0; i < 26; i++)
			if (count[i] == 0) {

				System.out.println("not pangram");
				return;
			}
		
		System.out.println("pangram");
	}

}
