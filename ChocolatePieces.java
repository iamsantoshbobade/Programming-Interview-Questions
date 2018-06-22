package code;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ChocolatePieces {

	static void max_Chocolates(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			long K = arr[i];
			long maxCuts = 0;
			for (int horizontalCuts = 1; horizontalCuts <= K; horizontalCuts++) {
				long verticalCutes = K - horizontalCuts;
				long cuts = horizontalCuts * verticalCutes;
				if (cuts > maxCuts)
					maxCuts = cuts;
			}
			System.out.println(maxCuts);
		}

	}

	public static void main(String[] args) throws IOException {
		int arr[] = { 5, 6, 7, 8,9 };
		max_Chocolates(arr);

	}

}
