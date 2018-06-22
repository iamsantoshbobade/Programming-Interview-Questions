package code;

public class CounterGame {

	private static int setBits(long n) {
		int count = 0;
		while (n > 0) {
			n = n & (n - 1);
			count++;

		}

		return count;
	}

	public static void main(String[] args) {

		// BigInteger n = new BigInteger("45");
		long n = 3;
		if ((setBits(n-1) & 1) == 1)
			System.out.println("Louis");
		else
			System.out.println("Richard");

	}

}
