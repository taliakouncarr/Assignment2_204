
public class QueueOverflowException extends Exception {

	/**
	 * Queue overflow exception class
	 */
	public QueueOverflowException() {
		super("Enqueue method has been called on a full queue.");
	}

}
