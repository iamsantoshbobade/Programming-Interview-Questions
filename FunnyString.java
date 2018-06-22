package code;

public class FunnyString {

	public static void main(String[] args) {
		String s1 = "acxy";

		StringBuffer org = new StringBuffer(s1);
		String rev = org.reverse().toString();

		boolean flag = false;

		for (int i = 0; i < s1.length() - 1; i++)
			if (Math.abs(s1.charAt(i) - s1.charAt(i + 1)) != Math.abs(rev.charAt(i) - rev.charAt(i + 1))) {
				flag = true;
				break;
			}
		if (flag)
			System.out.println("Not Funny");
		else
			System.out.println("Funny");

	}

}
