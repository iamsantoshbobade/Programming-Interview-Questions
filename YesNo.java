package code;

import java.io.IOException;

public class YesNo {

	static String isitpossible(int a, int b, int c, int d) {
		if (a > 1000 || b > 1000 || c > 1000 || d > 1000)
			return "No";
		if (a < 1 || b < 1 || c < 1 || d < 1)
			return "No";
		if (a > c || b > d)
			return "No";
		int sum1 = 0;
		if (b == d) {
			sum1 = a + b;
			if (sum1 == c)
				return "Yes";
			isitpossible(sum1, b, c, d);
		} else if (a == c) {
			sum1 = a + b;
			if (sum1 == d)
				return "Yes";
			isitpossible(a, sum1, c, d);
		}
		if (isitpossible(a + b, b, c, d).equals("Yes")) {
			return "Yes";
		} else if (isitpossible(a, a + b, c, d).equals("Yes")) {
			return "Yes";

		}
		isitpossible(a, a + b, c, d);

		if (a == c && b == d)
			return "Yes";
		return "No";
	}

	public static void main(String[] args) throws IOException {
		System.out.println(isitpossible(1, 4, 5, 9));

	}

}
