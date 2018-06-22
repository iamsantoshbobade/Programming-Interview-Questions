package code;

import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedianWithPriorityQueues {
	
	static PriorityQueue<Integer> l = new PriorityQueue<Integer>(10, Collections.reverseOrder()); //max heap on left
	static PriorityQueue<Integer> r = new PriorityQueue<Integer>(10); //min heap on right

	static void printMeds(int v){
	        //add to one of the heaps
	        if (l.size() == 0 || v <= l.peek()) l.add(v);
	        else r.add(v);

	        //ensure balance
	        if (l.size() - r.size() == 2) r.add(l.poll()); // l is too large
	        if (r.size() - l.size() == 2)l.add(r.poll()); //r is too large

	        double m = 0;

	        //calc median
	        if (l.size() == r.size()) m = ((double) l.peek() + (double) r.peek())/2;
	        else if (l.size() > r.size()) m = (double) l.peek();
	        else m = r.peek();
	        System.out.println(m);
	}
	
	public static void main(String[] args) {

		int n = 35;
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
				95912,
				13449,
				92211,
				17073,
				69230,
				22016,
				22120,
				78563,
				16571,
				1817,
				41510,
				74518,
				81638,
				89659,
				60445,
				35597,
				15237,
				88830,
				26019,
				77519,
				10914,
				36827,
				98074,
				31450,
				89952
				};
		int a[] = new int[n];
		
		//see testcase.txt
		for (int i = 0; i < n; i++) {
			
			if(i==10)
				;//System.out.println("LOL");
			//System.out.println("Ca");

			//insertIntoSortedArray(a, i, data[i]);
			 a[i] = data[i];
			 printMeds(data[i]);
			
			//System.out.print((i+1)+"  ");

			/*if ((i + 1) % 2 == 1) {
				System.out.println((float)a[i / 2]);
			} else {
				float sum = a[i / 2] + (float) a[(i / 2) + 1];
				System.out.println(sum / 2.0);
			}*/
		}
	
	}


}
