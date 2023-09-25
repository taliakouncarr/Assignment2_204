
public class Notation {
	/**
	 * @author Talia Notation class
	 * 
	 */

	/**
	 * 
	 * @param x
	 * @return
	 */
	public static int operations(String x) { // This is the precedence method

		switch (x) {

		case ("+"):
			return 1;

		case ("-"):
			return 2;
		case ("/"):
			return 3;
		case ("*"):
			return 4;
		}
		return -1;
	}

	/**
	 * Convert an infix expression into a postfix expression

	 * @param infix
	 * @return
	 * @throws InvalidNotationFormatException
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		MyStack<String> mystack = new MyStack<String>(); // Declare the stack
		MyQueue<String> myqueue = new MyQueue<String>(); // Declare the queue
		int openParenthesesCount = 0; // Track the count of open parentheses

		for (int i = 0; i < infix.length(); i++) { // read the string
			char currentChar = infix.charAt(i);

			if (Character.isDigit(currentChar)) { // Check if the current character in the infix is a digit
				try {
					myqueue.enqueue(Character.toString(currentChar));
				} catch (QueueOverflowException e) {
					e.printStackTrace();
				} // copy it to the postfix solution queue
			} else if (currentChar == '(') { // Check if the current character in the infix is a left parenthesis
				try {
					mystack.push(Character.toString(currentChar));
					openParenthesesCount++; // Increment open parentheses count
				} catch (StackOverflowException e) {
					e.printStackTrace();
				} // push it onto the stack
			} else if (currentChar == ')') { // Check if the current character in the infix is a closing parenthesis
				if (mystack.isEmpty()) { // If the stack is empty, it's a mismatched parenthesis
					throw new InvalidNotationFormatException();
				}
				// Pop operators from the stack and insert them in postfix solution queue
				try {
					while (!mystack.isEmpty() && !mystack.top().equals("(")) {
						try {
							myqueue.enqueue(mystack.pop());
						} catch (StackUnderflowException e) {
							e.printStackTrace();
						} catch (QueueOverflowException e) {
							e.printStackTrace();
						}
					}
				} catch (StackUnderflowException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					if (!mystack.isEmpty()) {
						mystack.pop(); // Pop the remaining open parenthesis
						openParenthesesCount--; // Decrement open parentheses count
					} else {
						throw new InvalidNotationFormatException();
					}
				} catch (StackUnderflowException e) {
					e.printStackTrace();
				}
			} else if (currentChar == '+' || currentChar == '-' || currentChar == '/' || currentChar == '*') {
				// Check if the current character is an operator
				try {
					while (!mystack.isEmpty()
							&& operations(mystack.top()) >= operations(Character.toString(currentChar))) {
						myqueue.enqueue(mystack.pop()); // Pop the operator and insert the popped one in postfix queue
					}
					mystack.push(Character.toString(currentChar)); // Push the current character in the infix onto the
																	// stack
				} catch (StackUnderflowException | StackOverflowException | QueueOverflowException e) {
					e.printStackTrace();
				}
			}
		}

		// After processing the expression, if there are open parentheses remaining,
		// it's a mismatched parenthesis
		if (openParenthesesCount != 0) {
			throw new InvalidNotationFormatException();
		}

		// Pop any remaining operators and insert them in postfix solution queue
		while (!mystack.isEmpty()) {
			try {
				myqueue.enqueue(mystack.pop());
			} catch (QueueOverflowException | StackUnderflowException e) {
				e.printStackTrace();
			}
		}

		return myqueue.toString();
	}

	/**
	 * Evaluates a postfix expression from a string to a double

	 * @param post
	 * @return
	 * @throws InvalidNotationFormatException
	 */
	public static Double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
		MyStack<String> mystack = new MyStack<String>(); // Declare my stack

		for (int i = 0; i < postfixExpr.length(); i++) { // read the expression

			if (Character.isDigit(postfixExpr.charAt(i)) || (postfixExpr.charAt(i) == '(')) { // If the current character is an
																				// operand or left parenthesis,
				// push on the stack
				try {
					mystack.push(Character.toString(postfixExpr.charAt(i)));
				} catch (StackOverflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// Check if the current character is an operator.
			else if ((postfixExpr.charAt(i)) == '+' || postfixExpr.charAt(i) == '-' || postfixExpr.charAt(i) == '/'
					|| postfixExpr.charAt(i) == '*') {
				if (mystack.size() < 2) { // Check if the size of the stack is less than two.
					throw new InvalidNotationFormatException(); // throw InvalidNotationFormatException excpetion.
				} else {

					String v1 = null;
					try {
						v1 = mystack.pop();
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} // pop the first value

					String v2 = null;
					try {
						v2 = mystack.pop();
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} // pop the second value
					double result = 0.0;// store the result of the operations

					/*
					 * Perform the arithmetic calculation of the operator- with the first popped
					 * value as the right operand and the second popped value as the left operand
					 */
					if (postfixExpr.charAt(i) == '+') {
						Double x = Double.parseDouble(v1);
						Double x2 = Double.parseDouble(v2);
						result = +x2 + x;
					}

					else if (postfixExpr.charAt(i) == '-') {
						Double x = Double.parseDouble(v1);
						Double x2 = Double.parseDouble(v2);
						result = +x2 - x;
					} else if (postfixExpr.charAt(i) == '/') {

						Double x = Double.parseDouble(v1);
						Double x2 = Double.parseDouble(v2);
						result = +x2 / x;
					} else if (postfixExpr.charAt(i) == '*') {

						Double x = Double.parseDouble(v1);
						Double x2 = Double.parseDouble(v2);
						result = +x2 * x;
					}

					try {
						mystack.push(String.valueOf(result));
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} // Push the resulting value onto the stack
				}
			}

		}

		if (mystack.size() == 1) {
			try {
				return Double.parseDouble(mystack.pop());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (StackUnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			throw new InvalidNotationFormatException(); // if more than one value remains, throw an error.
		}
		return null;
	}

	/**
	 * Convert the Postfix expression to the Infix expression

	 * @param posttoinfix
	 * @return
	 * @throws InvalidNotationFormatException
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {

		MyStack<String> mystack = new MyStack<String>(); // Declare a stack.

		// read the expression characters
		for (int i = 0; i < postfix.length(); i++) {
			if (Character.isDigit(postfix.charAt(i))) { // If the current character is an operand,
				// push on the stack

				try {
					mystack.push(Character.toString(postfix.charAt(i)));
				} catch (StackOverflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// Check if the current character is an operator.
			else if ((postfix.charAt(i)) == '+' || postfix.charAt(i) == '-' || postfix.charAt(i) == '/'
					|| postfix.charAt(i) == '*') {
				if (mystack.size() < 2) { //// Check if the size of the stack is less than two.
					throw new InvalidNotationFormatException(); // throw InvalidNotationFormatException
				} else {
					String v1 = null;
					try {
						v1 = mystack.pop();
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} // pop the first value
					String v2 = null;
					try {
						v2 = mystack.pop();
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} // pop the second value
					String infix = "(" + v2 + postfix.charAt(i) + v1 + ")"; // Encapsulate the resulting string
																				// within parenthesis.
					try {
						mystack.push(infix);
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} // push it to the stack.
				}
			}
		}

		if (mystack.size() != 1) // if more than one value remains in the stack, throw exception.
		{
			throw new InvalidNotationFormatException();

		} else {
			String result = null;
			try {
				result = mystack.pop();
			} catch (StackUnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
	}
}