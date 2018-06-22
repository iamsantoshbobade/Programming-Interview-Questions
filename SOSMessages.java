package code;

public class SOSMessages {

	public static void main(String[] args) {
		String S = "SOSGGS";
		int count = 0;
		for(int i=0;i<S.length()-2;i=i+3){
			String temp = S.substring(i, i+3);
			if(temp.equals("SOS"))
				continue;
			char ch = temp.charAt(0);
			if(ch!='S') count++;
			ch = temp.charAt(1);
			if(ch!='O') count++;
			ch = temp.charAt(2);
			if(ch!='S') count++;
		}
		System.out.println(count);
		
		
		
		
		
		
	}

}
