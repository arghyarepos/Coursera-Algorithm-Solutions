import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
	Bracket(char type, int position) {
		this.type = type;
		this.position = position;
	}

	boolean Match(char c) {
		if (this.type == '[' && c == ']')
			return true;
		if (this.type == '{' && c == '}')
			return true;
		if (this.type == '(' && c == ')')
			return true;
		return false;
	}

	char type;
	int position;
}

class check_brackets {
	private static Bracket currentBracket;

	public static void main(String[] args) throws IOException {
		InputStreamReader input_stream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input_stream);
		String text = reader.readLine();

		int result = check(text);

		// Printing answer, write your code here
	}

	private static int check(String text) {

		int flag = 0;
		Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
		for (int position = 0; position < text.length(); ++position) {
			char next = text.charAt(position);
			currentBracket = new Bracket(next, position);

			if (next == '(' || next == '[' || next == '{') {
				// Process opening bracket, write your code here
				opening_brackets_stack.push(currentBracket);
			}

			

			if (next == ')' || next == ']' || next == '}') {
				// Process closing bracket, write your code here
				if (!opening_brackets_stack.isEmpty()) {
					Bracket bracketOnTop = opening_brackets_stack.pop();

					
					
					if ((currentBracket.type == '[' && next != ']') || (currentBracket.type == '[' && next != ']')
							|| (currentBracket.type == '[' && next != ']')) {
						
						System.out.println((position + 1));
						return position + 1;

					}
					
					if (!bracketOnTop.Match(next)) {
						System.out.println((position + 1));
						return position + 1;
					}
					flag = 1;
				}else
				{
					System.out.println((position + 1));
					return position + 1;
				}

			}
		}

		
		if (opening_brackets_stack.isEmpty() ) {

			System.out.println("Success");
			return 0;
		
		}
		else{
			
				System.out.println((opening_brackets_stack.peek().position+1));
				return (opening_brackets_stack.peek().position+1) ;
		
		}
	
	
	}
}

