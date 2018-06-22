package code;

import java.util.Collection;
import java.util.LinkedHashMap;

public class FindAnagrams {
	public static int numberNeeded(String first, String second) {

		LinkedHashMap<Character, Integer> count = new LinkedHashMap<>();

		for (char ch : first.toCharArray()) {
			int c = count.containsKey(ch) ? count.get(ch) : 0;
			count.put(ch, c + 1);
		}

		for (char ch : second.toCharArray()) {
			int c = count.containsKey(ch) ? count.get(ch) : 0;
			count.put(ch, c - 1);
		}

		Collection<Integer> values = count.values();
		int modCount = 0;
		for (Integer v : values) {
			modCount += Math.abs(v);
		}

		return modCount;
	}

	public static void main(String[] args) {
		String a = "abc";
		String b = "ad";

		System.out.println(numberNeeded(a, b));
	}
}
