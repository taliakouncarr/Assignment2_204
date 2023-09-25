
public class QueueUnderflowException extends Exception{

	/**
	 * queue underflow exception class
	 */
	public QueueUnderflowException() {
		super("Dequeue method has been called on an empty queue.");
}
}