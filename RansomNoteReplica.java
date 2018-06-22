package code;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RansomNoteReplica {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public RansomNoteReplica(String magazine, String note) {
    	magazineMap = new HashMap<String, Integer>();
    	noteMap = new HashMap<String, Integer>();
    	String magazinWords[] = magazine.split(" ");
    	String noteWords[] = note.split(" ");
    	
    	for(String a : magazinWords){
    		int t = magazineMap.containsKey(a)?magazineMap.get(a):0;
    		magazineMap.put(a, t+1);
    	}
    	
    	for(String a : noteWords){
    		int t = noteMap.containsKey(a)?noteMap.get(a):0;
    		noteMap.put(a, t+1);
    	}
    	
    }
    
    public boolean solve() {
    	
    	
    	Iterator it = noteMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            String noteWord = pair.getKey().toString();
            if(!magazineMap.containsKey(noteWord)) return false;
            if(magazineMap.get(noteWord) < Integer.parseInt(pair.getValue().toString())) return false;
        }
    	
    	
    	
    	return true;
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        RansomNoteReplica s = new RansomNoteReplica("give me one grand today night", "give one grand today");

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}