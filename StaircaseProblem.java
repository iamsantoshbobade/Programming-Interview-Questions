package code;

public class StaircaseProblem {

	public StaircaseProblem() {
		for (int i = 0; i < 40; i++)
			a[i] = -1;
	}

	int a[] = new int[40];

	private int countSteps(int steps) {
		if (steps < 0)
			return 0;
		if (steps == 0)
			return 1;

		if (a[steps] != -1)
			return a[steps];

		a[steps] = countSteps(steps - 1) + countSteps(steps - 2) + countSteps(steps - 3);

		return a[steps];

	}

	public static void main(String[] args) {
		int s = 1;
		StaircaseProblem problem = new StaircaseProblem();
		for (int a0 = 0; a0 < s; a0++) {
			int n = 7;
			System.out.println(problem.countSteps(n));
		}
	}

}
