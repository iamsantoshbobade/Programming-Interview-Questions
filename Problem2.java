package code;

import java.util.Scanner;

public class Problem2 {

	static int countSeriesTerms(int A, int D, int B, int R, int Lim) {

		int count = 0;
		int APstart = A;
		int GPstart = B;
		while (B <= Lim) {
			A = APstart;
			while (A <= B) {
				if (A == B) {
					count++;
					break;
				} else {
					A = A + D;
				}
			}
			B = B * R;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;
		/*
		 * int _A; _A = Integer.parseInt(in.nextLine());
		 * 
		 * int _D; _D = Integer.parseInt(in.nextLine());
		 * 
		 * int _B; _B = Integer.parseInt(in.nextLine());
		 * 
		 * int _R; _R = Integer.parseInt(in.nextLine());
		 * 
		 * int _Lim; _Lim = Integer.parseInt(in.nextLine());
		 */

		res = countSeriesTerms(1000000, 1, 250, 20, 1000000);
		System.out.println("KK" + res);

	}

}
