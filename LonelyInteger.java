package code;

public class LonelyInteger {

	public static int lonelyInteger(int[] a) {
		int result = 0;
		for(int i =0;i<a.length;i++)
			result = result ^ a[i];
		
		return result;

	}

	public static void main(String[] args) {
		int a[] = {1,2,1};
		System.out.println(lonelyInteger(a));
	}

}
