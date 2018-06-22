package code;

public class CamelCaseWords {

	public static void main(String[] args) {

		String s = "guessTheCountOfWords";
		int count = 1;
		for (int i = 0; i < s.length(); i++)
			if ( s.charAt(i) <= 'Z')
				count++;

		System.out.println(count);

	}

}
