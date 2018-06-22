package code;

public class SortArray {

	private static void rotate(int a[]) {
		int temp = a[0];
		a[0] = a[1];
		a[1] = a[2];
		a[2] = temp;
	}

	private static boolean isSortable(int a[], int startIndex, int length) {
		boolean isPossoible = false;
		
		if(length < 3)
			return false;

		if (length == 3) {
			if (isSorted(a))
				return true;
			rotate(a);
			if (isSorted(a))
				return true;

			rotate(a);
			if (isSorted(a))
				return true;
			// isSortable(a, 0, length - 1);
		}
		
		return isSortable(a, 0, length - 1);

	
	}

	private static boolean isSorted(int a[]) {
		boolean ans = true;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				ans = false;
				break;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int a[] = { 1,3,4,2 };
		System.out.println(isSortable(a, 0, a.length));

	}

}
