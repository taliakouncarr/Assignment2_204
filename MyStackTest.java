import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
/**
 * 
 * @author Talia
 *
 */
public class MyStackTest {
	
	//our variables
	public MyStack<String> stringS;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleS
	public MyStack<Double> doubleS;
	// STUDENT: add variables as needed for your student tests
	public Double t=4.0, j=12.11, m=19.75, l=19.7, w=200.0;
	@BeforeEach
	/**
	 * 
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		stringS = new MyStack<String>(5);
		stringS.push(a);
		stringS.push(b);
		stringS.push(c);
		
		//STUDENT: add setup for doubleS for student tests
		doubleS= new MyStack<Double>(5);
		doubleS.push(l);
		doubleS.push(w);
		doubleS.push(m);
	}

	@AfterEach
	/**
	 * 
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		stringS = null;
		doubleS = null;
	}

	@Test
	/**
	 * 
	 * @throws StackUnderflowException
	 */
	public void testIsEmpty() throws StackUnderflowException {
		assertEquals(false,stringS.isEmpty());
		stringS.pop();
		stringS.pop();
		stringS.pop();
		assertEquals(true, stringS.isEmpty());
	}

	@Test
	/**
	 * 
	 * @throws StackOverflowException
	 */
	public void testIsFull() throws StackOverflowException {
		assertEquals(false, stringS.isFull());
		stringS.push(d);
		stringS.push(e);
		assertEquals(true, stringS.isFull());
	}

	@Test
	/**
	 * 
	 */
	public void testPop() {
		try {
			assertEquals(c, stringS.pop());
			assertEquals(b, stringS.pop());
			assertEquals(a, stringS.pop());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringS.pop();
			assertTrue(false, "This should have caused an StackUnderflowException");
		}
		catch (StackUnderflowException e){
			assertTrue(true, "This should have caused an StackUnderflowException");
		}
		catch (Exception e){
			assertTrue(false, "This should have caused an StackUnderflowException");
		}
	}

	
	// t=4.0, j=12.11, m=19.75, l=19.70, w=200.0
	@Test
	/**
	 * 
	 */
	public void testPopStudent() {
		try {
			assertEquals (19.7, doubleS.pop(), 001);
			assertEquals (200.0, doubleS.pop(), 001);
			assertEquals (19.75, doubleS.pop(), 001);

		}
		catch (StackUnderflowException e) {
			assertTrue("Threw StackUnderFlowException", true);
			
		}
		catch (Exception e) {
			assertTrue("Threw StackUnderflowException", false);
		}
	}

	@Test
	/**
	 * 
	 * @throws StackUnderflowException
	 * @throws StackOverflowException
	 */
	public void testTop() throws StackUnderflowException, StackOverflowException {
		assertEquals(c, stringS.top());
		stringS.push(d);
		assertEquals(d, stringS.top());
		stringS.pop();
		stringS.pop();
		assertEquals(b, stringS.top());		
	}

	@Test
	/**
	 * 
	 * @throws StackOverflowException
	 * @throws StackUnderflowException
	 */
	public void testSize() throws StackOverflowException, StackUnderflowException {
		assertEquals(3, stringS.size());
		stringS.push(d);
		assertEquals(4, stringS.size());
		stringS.pop();
		stringS.pop();
		assertEquals(2, stringS.size());
	}

	@Test
	/**
	 * 
	 */
	public void testPush() {
		try {
			assertEquals(3, stringS.size());
			assertEquals(true, stringS.push(d));
			assertEquals(4, stringS.size());
			assertEquals(true, stringS.push(e));
			assertEquals(5, stringS.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringS.push(f);
			assertTrue(false, "This should have caused an StackOverflowException");
		}
		catch (StackOverflowException e){
			assertTrue(true, "This should have caused an StackOverflowException");
		}
		catch (Exception e){
			assertTrue(false, "This should have caused an StackOverflowException");
		}
	}

	
	// t=4.0, j=12.11, m=19.75, l=19.70, w=200.0

	@Test
	/**
	 * 
	 */
	public void testPushStudent() {
		try {
			assertEquals(3, doubleS.size());
			assertEquals(true, doubleS.push(j));
			assertEquals(4, doubleS.size());
			assertEquals (true, doubleS.push(t));
			assertEquals(5, doubleS.size());
			
		doubleS.push(w);
		assertTrue ("Threw a StackOverFlowException", false);
		}
		catch (StackOverflowException e) {
			assertTrue("Threw a StackOverFlowException", true);
			
		}
		catch (Exception e) {
			assertTrue("Threw a StackOverFlowException", false);
		}
	
	}
	
	@Test
	/**
	 * 
	 * @throws StackOverflowException
	 */
	public void testToString() throws StackOverflowException {
		assertEquals("abc", stringS.toString());
		stringS.push(d);
		assertEquals("abcd", stringS.toString());
		stringS.push(e);
		assertEquals("abcde", stringS.toString());
	}

	
	// t=4.0, j=12.11, m=19.75, l=19.70, w=200.0

	@Test
	/**
	 * 
	 * @throws StackOverflowException
	 */
	public void testToStringStudent() throws StackOverflowException {
		assertEquals("19.7200.019.75", doubleS.toString());
		doubleS.push(j);
		assertEquals("19.7200.019.7512.11", doubleS.toString());

	}
		
	
	@Test
	/**
	 * 
	 * @throws StackOverflowException
	 */
	public void testToStringDelimiter() throws StackOverflowException {
		assertEquals("a%b%c", stringS.toString("%"));
		stringS.push(d);
		assertEquals("a&b&c&d", stringS.toString("&"));
		stringS.push(e);
		assertEquals("a/b/c/d/e", stringS.toString("/"));
	}

	@Test
	/**
	 * 
	 * @throws StackOverflowException
	 * @throws StackUnderflowException
	 */
	public void testFill() throws StackOverflowException, StackUnderflowException {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringS = new MyStack<String>(5);
		//fill with an ArrayList
		stringS.fill(fill);
		assertEquals(3,stringS.size());
		assertEquals("carrot", stringS.pop());
		assertEquals("banana", stringS.pop());
		assertEquals("apple", stringS.pop());		
	}

}
