package code;

import java.util.Arrays;
import java.util.Comparator;

class Checker implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {

		if (o1.score < o2.score) {
			return 1;
		}
		if (o1.score > o2.score)
			return -1;

		return (o1.name.compareTo(o2.name));

	}

}

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

public class ComparatorSorter {

	public static void main(String[] args) {
		int n = 5;
		int index = 0;

		Player[] player = new Player[n];
		Checker checker = new Checker();

		String names[] = { "amy", "david", "heraldo", "aakansha", "aleska" };
		int scores[] = { 100, 100, 50, 75, 150 };

		for (int i = 0; i < n; i++, index++) {
			player[i] = new Player(names[index], scores[index]);
		}

		Arrays.sort(player, checker);
		for (int i = 0; i < player.length; i++) {
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
	}
}