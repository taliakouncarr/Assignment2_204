
public class StackOverflowException extends Exception {
	
	/**
	 * stack overflow exception class
	 */
	public StackOverflowException() {
		super("A push method has been called on a full stack.");
	}

}
