package code;

import java.util.ArrayList;

public class ContactsBook {

	static ArrayList<String> contacts = new ArrayList<>();
	private static void add(String contact){
		contacts.add(contact);
	}
	
	private static int find(String partial){
		int count =  0;
		for(String c : contacts)
			if(c.startsWith(partial)) count++;
		
		
		return count;
	}
	public static void main(String[] args) {
		// Scanner in = new Scanner(System.in);
		int n = 4;
		int index = 0;
		int a[] = { 1, 1, 2, 2 };
		String data[] = { "hackerrank", "hacker" };
		String partial = "hak";
		for (int i = 0; i < n; i++) {
			
			if(a[i] == 1){
				String contact = data[index++];
				add(contact);
			}else{
				System.out.println("Count: "+find(partial));
			}
		}
	}
}