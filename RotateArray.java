package code;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

		int len = a.length;

		int k = 1;

		/*for (int i = 1; i <= k; i++) {
			int temp = a[0];
			a[0] = a[a.length - 1];
			for (int j = a.length - 1; j > 1; j--) {
				a[j] = a[j - 1];

			}
			a[1] = temp;
		}*/

		System.out.print("\nOriginal Array: ");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]+ " ");
		
		System.out.println();

		int start = a[(len + k - 1) % len];
		System.out.println("Start:"+start);
		int index = (len + k - 1) % len;
		System.out.println("Index:"+index);
		System.out.println();
		int temp=a[len-1];
		for (int i = len - 1; i > index; i--)
			a[i] = a[i - 1];
		for (int i = index - 1; i > 1; i--)
			;
		// a[i] = a[i-1];

		a[index] = temp;
		

		for (int i = len - 1; i > 1; i--) {
			;//start = a[len - 1];

		}
		
		
		System.out.print("\nRotated Array: ");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]+ " ");
		
		System.out.println();

	}

}
