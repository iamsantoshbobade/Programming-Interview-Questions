package code;

public class RunningMedianHeap {

	private static void insertIntoSortedArray(int a[], int index, int item) {
		if (index == 0) {
			a[index] = item;
			return;
		}
		int pos = 0;
		int i = 0;
		boolean found = false;
		while (i < index) {
			if (a[i] < item){
				i++;
				continue;
			}
			
			break;
		}
		pos = i;
		for (int j = index; j > pos; j--) {
			a[j] = a[j - 1];
		}
		a[pos] = item;
	}

	public static void main(String[] args) {
		int n = 11;
		int data[] = { 
				94455,
				20555,
				20535,
				53125,
				73634,
				148,
				63772,
				17738,
				62995,
				13401,
				95912
				};
		int a[] = new int[n];
		
		//see testcase.txt
		for (int i = 0; i < n; i++) {
			
			if(i==10)
				System.out.println("LOL");
			//System.out.println("Ca");

			insertIntoSortedArray(a, i, data[i]);
			// a[i] = data[i];
			
			System.out.print((i+1)+"  ");

			if ((i + 1) % 2 == 1) {
				System.out.println((float)a[i / 2]);
			} else {
				float sum = a[i / 2] + (float) a[(i / 2) + 1];
				System.out.println(sum / 2.0);
			}
		}
	}

}
