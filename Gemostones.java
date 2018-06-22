package code;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Gemostones {

	public static void main(String[] args) {
		HashMap<Character, Integer> count = new HashMap<Character, Integer>();
		System.out.println(count.get('c'));

		int N = 1;
		
		String s[] = new String[100];
		N = 2;
		s[0]="abcd";
		s[1]="abee";
		int gems = 0;
		for (int i = 0; i < N; i++) {
			String str = s[i];
			for(int k =0;k<str.length();k++){
				char ch = str.charAt(k);
				Integer c = count.get(ch);
				if(c==null) count.put(ch, 1);
				else if(c==i) {
				 count.put(ch, i+1) ;
				}
			}

		}
		
		Iterator it = count.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<Character,Integer> pair = (Map.Entry<Character,Integer>)it.next();
	        if(pair.getValue() == N) {
	        	//System.out.println(pair.getKey());
	        	gems++;
	        }
	    }
	    
	    System.out.println(gems);
	}

}
