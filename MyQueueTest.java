//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 
 * @author Talia
 *
 */
public class MyQueueTest {
	
	//create variables
	public MyQueue<String> stringQ;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleQ
	public MyQueue<Double> doubleQ;
public Double l= 33.2, m= 143.65, n=88.65, o=32.8, p=203.4, q=94.3;

	@BeforeEach
	/**
	 * 
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		stringQ = new MyQueue<String>(5);
		stringQ.enqueue(a);
		stringQ.enqueue(b);
		stringQ.enqueue(c);
		
		//STUDENT: add setup for doubleQ for student tests
		doubleQ = new MyQueue <Double> (6);
		doubleQ.enqueue(l);
		doubleQ.enqueue(m);
		doubleQ.enqueue(n);
		doubleQ.enqueue(o);
		
	}

	@AfterEach
	/**
	 * 
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		stringQ = null;
		doubleQ = null;
	}

	@Test
	/**
	 * 
	 * @throws QueueUnderflowException
	 */
	public void testIsEmpty() throws QueueUnderflowException {
		assertEquals(false,stringQ.isEmpty());
		stringQ.dequeue();
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(true, stringQ.isEmpty());
	}

	@Test
	/**
	 * 
	 */
	public void testDequeue() {
		try {
			assertEquals(a, stringQ.dequeue());
			assertEquals(b, stringQ.dequeue());
			assertEquals(c, stringQ.dequeue());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringQ.dequeue();
			assertTrue(false, "This should have caused an QueueUnderflowException");
		}
		catch (QueueUnderflowException e){
			assertTrue(true, "This should have caused an QueueUnderflowException");
		}
		catch (Exception e){
			assertTrue(false, "This should have caused an QueueUnderflowException");
		}
	}
	
	@Test
	/**
	 * 
	 */
	//l= 33.2, m= 143.65, n=88.65, o=32.8
	public void testDequeueStudent() {
		try {
		assertEquals (33.2, doubleQ.dequeue(), 001);
		assertEquals (143.65, doubleQ.dequeue(), 001);
		assertEquals (88.65, doubleQ.dequeue(), 001);
		assertEquals(32.8, doubleQ.dequeue(),001);

		doubleQ.dequeue();
		assertTrue ("This should have caused a QueueUnderFlowException", false);
		}
		catch (QueueUnderflowException e) {
			assertFalse("This should have caused a QueueUnderflowException", false);
		}
		catch (Exception e) {
			assertTrue ("Threw a QueueUnderflowException", false);
		}
	}

	@Test
	/**
	 * 
	 * @throws QueueOverflowException
	 * @throws QueueUnderflowException
	 */
	public void testSize() throws QueueOverflowException, QueueUnderflowException {
		assertEquals(3, stringQ.size());
		stringQ.enqueue(d);
		assertEquals(4, stringQ.size());
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(2, stringQ.size());
	}

	@Test
	/**
	 * 
	 */
	public void testEnqueue() {
		try {
			assertEquals(3, stringQ.size());
			assertEquals(true, stringQ.enqueue(d));
			assertEquals(4, stringQ.size());
			assertEquals(true, stringQ.enqueue(e));
			assertEquals(5, stringQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringQ.enqueue(f);
			assertTrue(false, "This should have caused an QueueOverflowException");
		}
		catch (QueueOverflowException e){
			assertTrue(true, "This should have caused an QueueOverflowException");
		}
		catch (Exception e){
			assertTrue(false, "This should have caused an QueueOverflowException");
		}
	}

	//l= 33.2, m= 143.65, n=88.65, o=32.8

	@Test
	/**
	 * 
	 */
	public void testEnqueueStudent() {
		try {
		assertEquals(4, doubleQ.size());
		assertEquals(true, doubleQ.enqueue(l));
		assertEquals(5, doubleQ.size());
		assertEquals(true, doubleQ.enqueue(m));
		assertEquals(6,doubleQ.size());
		
		doubleQ.enqueue(o);
		assertTrue("Threw QueueOverflowException",false);
	}
		catch (QueueOverflowException e) {
			assertTrue("Threw QueueOverflowException", true);
			
		}
		catch (Exception e) {
			assertTrue("Threw QueueOverflowException", false);
		}
	}

	@Test
	/**
	 * 
	 * @throws QueueOverflowException
	 */
	public void testIsFull() throws QueueOverflowException {
		assertEquals(false, stringQ.isFull());
		stringQ.enqueue(d);
		stringQ.enqueue(e);
		assertEquals(true, stringQ.isFull());
	}

	@Test
	/**
	 * 
	 * @throws QueueOverflowException
	 */
	public void testToString() throws QueueOverflowException {
		assertEquals("abc", stringQ.toString());
		stringQ.enqueue(d);
		assertEquals("abcd", stringQ.toString());
		stringQ.enqueue(e);
		assertEquals("abcde", stringQ.toString());
	}
	
	
	//l= 33.2, m= 143.65, n=88.65, o=32.8, p=203.4, q=94.3
	@Test
	/**
	 * 
	 * @throws QueueOverflowException
	 */
	public void testToStringStudent() throws QueueOverflowException {
		assertEquals("33.2143.6588.6532.8", doubleQ.toString());
		doubleQ.enqueue(p);
		assertEquals("33.2143.6588.6532.8203.4", doubleQ.toString());
		
	}

	@Test
	/**
	 * 
	 * @throws QueueOverflowException
	 */
	public void testToStringDelimiter() throws QueueOverflowException {
		assertEquals("a%b%c", stringQ.toString("%"));
		stringQ.enqueue(d);
		assertEquals("a&b&c&d", stringQ.toString("&"));
		stringQ.enqueue(e);
		assertEquals("a/b/c/d/e", stringQ.toString("/"));
	}

	@Test
	/**
	 * 
	 * @throws QueueOverflowException
	 * @throws QueueUnderflowException
	 */
	public void testFill() throws QueueOverflowException, QueueUnderflowException {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringQ = new MyQueue<String>(5);
		//fill with an ArrayList
		stringQ.fill(fill);
		assertEquals(3,stringQ.size());
		assertEquals("apple", stringQ.dequeue());
		assertEquals("banana", stringQ.dequeue());
		assertEquals("carrot", stringQ.dequeue());		
	}

}
