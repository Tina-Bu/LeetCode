import java.util.*;

class ValidParenthesesSolution{
	public boolean check(String equation) {
		// create an empty stack
		Stack<Character> st = new Stack<>();
		
		for (char c : equation.toCharArray()) {
			
			if (isLeft(c)) {
				// push left parentheses to stack
				st.push(c);
			} else {
				// if matching right parentheses comes, pop
				// corner case: can't pop if stack is empty
				if (matches(st.peek(), c)) {
					st.pop();
				} else {
					// if not matching right parentheses comes, return wrong answer
					return false;
				}
			}
		}
		
		return st.isEmpty();
	}
	public boolean isLeft(char c) {
		return (c == '(' || c == '[' || c == '{');
	}
	
	public boolean matches(char l, char r) {
		HashMap<Character, Character> hm = new HashMap<Character, Character>();
		hm.put('(', ')');
		hm.put('[', ']');
		hm.put('{', '}');
		return r == hm.get(l); 
	}
	
}

class ValidParenthesesSolution2 {
	public boolean check(String equation) {
		// create an empty stack
		Stack<Character> stack = new Stack<>();
		
		for (char c : equation.toCharArray()) {
			switch (c) {
			case '(':
				stack.push(c);
				break;
			case '[':
				stack.push(c);
				break;
			case '{':
				stack.push(c);
				break;
			case ')':
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
				break;
			case ']':
				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
				break;
			case '}':
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
				break;
			}
		}
		return stack.size() == 0;
	}
}

/*
 * 优化类似代码，使更简洁
 * 
 * case '(', '[', '{' put to default or ')', ']', '}' to default
 * 		for (char c : equation.toCharArray()) {
			switch (c) {
			case '(':
				stack.push(')');
				break;
			case '[':
				stack.push(']');
				break;
			case '{':
				stack.push('}');
				break;
			default:
				if (stack.isEmpty() || stack.pop() != c) {
					return false;
				}
				break;
		}
 * 
 */

class ValidParenthesesSolution3 {
	public boolean check(String equation) {
		// worst case time complexity O(n^2) 
		// every scan is O(n), if 1 parentheses is removed every round, N round to finish
		// not the best solution but clean code
		while (equation.contains("()") || equation.contains("[]") || equation.contains("{}")) {
			equation = equation.replace("()", "");
			equation = equation.replace("[]", "");
			equation = equation.replace("{}", "");
		}
		return equation.length() == 0;
				
	}
}

/*
 * Modification 1
 * 
 * levels of parentheses: ([]) false, {{[()]}} true, {()} false, {[]} false
 * when push into stack, check if current value is of higher level than current one
 * 
 * Modification 2
 * 
 * equations with numeric values [6 * (5 + 3)] true, (6 * (5 + 3)) false
 */

public class ValidParentheses {
	public static void main(String[] args) {
		ValidParenthesesSolution3 s = new ValidParenthesesSolution3();
		System.out.println(s.check("()[]{}"));
		System.out.println(s.check(")}"));
		System.out.println(s.check("(({[]}[]))"));
		System.out.println(s.check(""));
	}
	
}
