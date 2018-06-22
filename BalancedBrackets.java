package code;

import java.util.Stack;

public class BalancedBrackets {

	static Stack<Character> stackNewestOnTop = new Stack<Character>();
/*
 * faild for NYYYN
 * 5
}][}}(}][))]
[](){()}
()
({}([][]))[]()
{)[](}]}]}))}(())(
 */
	public static boolean isBalanced(String expression) {
		char c = ' ';
		for (Character g : expression.toCharArray()) {
			if (g == '{' || g == '(' || g== '[')
				stackNewestOnTop.push(g);
			else{
				
				if(stackNewestOnTop.isEmpty()) return false;

				c = stackNewestOnTop.pop();
				if(g==')') {
					if(c != '(') return false;
					else continue;
				}
				
				if(g==']') {
					if(c != '[') return false;
					else continue;
				}
				
				if(g=='}') {
					if(c != '{') return false;
					else continue;
				}
			
			}
		}

		return stackNewestOnTop.isEmpty();
	}

	public static void main(String[] args) {
		int index = 0;
		String data[] = { "}][}}(}][))]", "[](){()}","()","({}([][]))[]()","{)[](}]}]}))}(())(" };
		for (int i = 0; i < 5; i++) {
			String expression = data[index++];
			boolean answer = isBalanced(expression);
			stackNewestOnTop = new Stack<Character>();
			if (answer)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}