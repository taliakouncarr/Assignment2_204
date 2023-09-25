import java.util.ArrayList;
import java.util.StringJoiner;

public class MyStack<T> implements StackInterface<T> {

	/**
	 * @author Talia
	 * myStack class
	 */
	
	//create variables
	private T[] stack;
	private int indextop = -1;
	private int size;
	private final static int DEFAULT_CAP = 110;

	/**
	 * takes in size of stack
	 * @param size
	 */
	public MyStack(int size) {
		this.size = size;
		stack = (T[]) new Object[size];
	}

	/**
	 * uses default as size of stack
	 */
	public MyStack() {
		this(DEFAULT_CAP);
	}

	@Override
	/**
	 * determines if stack is empty
	 */
	public boolean isEmpty() {

		return indextop == -1;

	}

	@Override
	/**
	 * determines if the stack is full
	 */
	public boolean isFull() {
		return indextop == stack.length - 1;

	}

	@Override
	/**
	 * deletes then returns element at top of stack
	 * @throws StackUnderflowException
	 */
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		} else {
			T element = stack[indextop];
			stack[indextop] = null;
			indextop--;
			return element;
		}
	}

	@Override
	/**
	 * returns element at top of stack
	 * @throws StackUnderflowException
	 */
	public T top() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		} else {
			T element = stack[indextop];
			return element;
		}
	}

	@Override
	/**
	 * returns number of elements in stack
	 */
	public int size() {
		return indextop + 1;
	}

	@Override
	/**
	 * adds element to top of stack
	 * @param e
	 * @throws StackOverflowException
	 */
	public boolean push(T e) throws StackOverflowException {
		if(isFull()){
			throw new StackOverflowException();
		} else {
			stack[indextop+1] = e;
			indextop++;
			return true;
		}
	}

	@Override
	/**
	 * returns elemets of stack in a string from bottom to top
	 * 
	 */
	public String toString() {
		String str = "";
		for (int i=0; i<= indextop; i++) {
			str+=stack[i];
		}
		
		return str;
	}
	
	@Override
	/**
	 * returns the string rep of elements in the stack
	 * @param delimiter
	 */
	public String toString(String delimiter) {
		  StringJoiner str = new StringJoiner(delimiter);

		    for (int i = 0; i <= indextop; i++) {
		        str.add(String.valueOf(stack[i]));
		    }

		    return str.toString();
	}

	@Override
	/**
	 * fills stack with elemts of array list
	 * @param list
	 * @throws StackOverflowException
	 */
	public void fill(ArrayList<T> list) throws StackOverflowException {
		if(isFull()) {
			throw new StackOverflowException();
		}
		else {
		for(int i = 0; i< list.size();i++) {
			T element=(list.get(i));
			push(element);
		}
	}
 
	
	}

}
