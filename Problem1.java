package code;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem1 {

	static String[] ReduceFraction(String[] fractions) {
		int length = fractions.length;
		String reducedFractions[] = new String[length];
		for (int i = 0; i < length; i++) {
			String inputFraction = fractions[i];
			String answer = "";
			int numerator = Integer.parseInt(inputFraction.split("/")[0]);
			int denominator = Integer.parseInt(inputFraction.split("/")[1]);

			int gcd = findGCD(numerator, denominator);

			numerator = numerator / gcd;
			denominator = denominator / gcd;
			answer = Integer.toString(numerator) + "/" + Integer.toString(denominator);

			reducedFractions[i] = answer;
		}

		return reducedFractions;

	}

	private static int findGCD(int numerator, int denominator) {
		if (denominator == 0) {
			return numerator;
		}

		return (findGCD(denominator, numerator % denominator));

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		String[] res;

		int _fractions_size = 0;
		_fractions_size = Integer.parseInt(in.nextLine());
		String[] _fractions = new String[_fractions_size];
		String _fractions_item;
		for (int _fractions_i = 0; _fractions_i < _fractions_size; _fractions_i++) {
			try {
				_fractions_item = in.nextLine();
			} catch (Exception e) {
				_fractions_item = null;
			}
			_fractions[_fractions_i] = _fractions_item;
		}

		res = ReduceFraction(_fractions);
		for (int res_i = 0; res_i < res.length; res_i++) {
			bw.write(String.valueOf(res[res_i]));
			bw.newLine();
		}

		bw.close();
	}
}
