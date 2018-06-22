package code;

public class BubbleSort {

	public static void main(String[] args) {
		int n = 3;
		int a[] = { 3,2,1};

		int c = 0;
		int numberOfSwaps = 1;
		for (int i = 0; i < n - 1 && numberOfSwaps != 0; i++) {
			// Track number of elements swapped during a single array traversal
			
			numberOfSwaps = 0;
			for (int j = n-1; j > i; j--) {
				// Swap adjacent elements if they are in decreasing order
				if (a[j] < a[j - 1]) {
					// swap(a[j], a[j + 1]);
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
					c++;
					numberOfSwaps++;
				}
			}

			// If no elements were swapped during a traversal, array is sorted
			if (numberOfSwaps == 0) {
				break;
			}
		}

		System.out.println(" Array is sorted in " + c + " swaps.");
		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element: " + a[n - 1]);
	}

}
