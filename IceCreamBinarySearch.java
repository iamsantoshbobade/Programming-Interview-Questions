package code;

import java.util.Arrays;
import java.util.HashMap;

class IceCream implements Comparable {

	int flavor;
	int index;

	public IceCream(int flavor, int index) {
		this.flavor = flavor;
		this.index = index;

	}

	@Override
	public int compareTo(Object o) {
		IceCream cream = (IceCream) o;
		if (flavor < cream.flavor)
			return -1;
		if (flavor > cream.flavor)
			return 1;

		return 0;

	}

	@Override
	public boolean equals(Object o) {
		IceCream cream = (IceCream) o;
		return (flavor == cream.flavor);
	}

}

public class IceCreamBinarySearch {

	public static int binarySearch(int first, int last, IceCream[] arr, int search) {

		while (last >= first) {
			int mid = (first + last) / 2;

			if (arr[mid].flavor == search)
				return arr[mid].index;
			if (arr[mid].flavor < search)
				first = mid + 1;
			if (arr[mid].flavor > search)
				last = mid - 1;
		}
		return -1;

	}

	/*
	 * 
	 * printSolution(c, m); => costs array and m
	 * 
	 * Solution by some random guy
	 * 
	 * 
	 * call printSolution right after creating ICECREAM array
	 * 
	 */

	private static void printSolution(int[] costs, int m) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int a = 0;
		int b = 0;
		for (int i = 0; i < costs.length; i++) {
			if (map.containsKey(m - costs[i])) {
				a = map.get(m - costs[i]);
				b = i + 1;
				break;
			}
			map.put(costs[i], i + 1);
		}
		System.out.println(a + " " + b);
	}

	public static void main(String[] args) {

		int t;
		int n, m;

		t = 1;
		// int c[] = { 1, 4, 5, 3, 2 };
		int c[] = { 2, 2, 4, 3 };
		for (int test = 0; test < t; test++) {

			m = 4;
			n = 4;
			IceCream[] arr = new IceCream[n];

			for (int i = 0; i < n; i++)
				arr[i] = new IceCream(c[i], i + 1);

			Arrays.sort(arr);
			int firstIndex = 100000, secondIndex = 100000;
			for (int i = 0; i < n - 1; i++) {
				int search = m - arr[i].flavor;
				if (search >= arr[i].flavor) {
					int index = binarySearch(i, n - 1, arr, search);
					if (index != -1) {
						System.out.println(Math.min(arr[i].index, index) + " " + Math.max(arr[i].index, index));
						break;

					}
				}
			}

		}

	}

}
