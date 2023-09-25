import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class MyQueue<T> implements QueueInterface<T> {

	/**
	 * My Queue class
	 * 
	 * @author Talia
	 */

	// create variables
	private int size;
	private T[] MyQueue;
	int front = 0;
	private final static int DEFAULT_CAP = 110;
	private int finalindex = -1;

	/**
	 * takes in the size of the queue
	 * @param size
	 */
	public MyQueue(int size) {
		this.size = size;
		MyQueue = (T[]) new Object[size];
	}

	/**
	 * uses a default as size of queue
	 */
	public MyQueue() {
		this(DEFAULT_CAP);
	}

	/**
	 *checks if queue is empty 
	 */
	@Override
	public boolean isEmpty() {
		return finalindex == -1;
	}

	/**
	 * checks if queue is full
	 */
	@Override
	public boolean isFull() {
		return finalindex == MyQueue.length - 1;
	}

	/**
	 * gets rid of and returns whatever element is at the front of queue
	 * @throws QueueUnderflowException
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		} else {
			T element = MyQueue[front];
			MyQueue[front] = null;
			front = (front + 1) % MyQueue.length;
			finalindex--;
			return element;
		}
	}

	/**
	 * returns num of elemts in queue
	 */
	@Override
	public int size() {
		return finalindex + 1;
	}

	@Override
	/**
	 * adds element to end of queue
	 * @param e
	 */
	public boolean enqueue(T e) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		} else {
			MyQueue[++finalindex] = e;
			return true;
		}
	}

	@Override
	/**
	 * will return the string representation of what is in the queue
	 */
	public String toString() {
		List<String> elements = new ArrayList<>();
		for (int i = 0; i <= finalindex; i++) {
			elements.add(String.valueOf(MyQueue[i]));
		}
		return String.join("", elements);
	}

	@Override
	/**
	 *will return the string representation of what is in the queue
	 *@param delimiter
	 */
	public String toString(String delimiter) {
		StringJoiner str = new StringJoiner(delimiter);
		for (int i = 0; i <= finalindex; i++) {
			str.add(String.valueOf(MyQueue[i]));
		}

		return str.toString();
	}

	@Override
	
	/**
	 * fills the queue with the elements of the arraylist
	 * @throws QUeueOverflowException
	 * @param list 
	 */
	public void fill(ArrayList<T> list) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		} else {
			for (int i = 0; i < list.size(); i++) {
				T element = (list.get(i));
				enqueue(element);
			}
		}
	}

}
