
public class StackUnderflowException extends Exception {

	/**
	 * stack underflow exception class
	 */
	public StackUnderflowException() {
		super("Top or pop method has been called on an empty stack.");
	}
}
