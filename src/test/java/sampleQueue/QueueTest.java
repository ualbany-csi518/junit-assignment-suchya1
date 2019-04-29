package sampleQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class QueueTest {

	/**
	 * Tests for Queue.
	 */

	private Queue<String> q;
	private Queue<String> q2;

	@Nested
	@DisplayName("When new empty queue")
	class WhenNew
	{
		@BeforeEach
		void testConstructor()
		{
			q=new Queue<String>();
		}
		@BeforeEach
		void testConstructor2()
		{
			q2=new Queue<String>(5);
		}
		@Test
		@DisplayName("is empty")
		void testIsEmptyWhenEmpty()
		{
			assertTrue(q.isEmpty());
		}
		@Test
		@DisplayName("is empty")
		void testIsEmptyWhenEmpty2()
		{
			assertTrue(q2.isEmpty());
		}
		@Test
		@DisplayName("dequeue when empty")
		void testDequeueWhenEmpty()
		{
			assertThrows(NoSuchElementException.class,()->{q.dequeue();},"Queue underflow");
		}
		@Test
		@DisplayName("dequeue when empty")
		void testDequeueWhenEmpty2()
		{
			assertThrows(NoSuchElementException.class,()->{q2.dequeue();},"Queue underflow");
		}
		@Test 
		@DisplayName("peek when empty")
		void testPeekWhenEmpty()
		{
			assertThrows(NoSuchElementException.class,()->{q.peek();},"Queue underflow");
		}
		@Test 
		@DisplayName("peek when empty")
		void testPeekWhenEmpty2()
		{
			assertThrows(NoSuchElementException.class,()->{q2.peek();},"Queue underflow");
		}
		@Test 
		@DisplayName("enqueue when empty")
		void testEnqueueWhenEmpty()
		{
			q.enqueue("test item");
			assertTrue(q.length()==1);
			assertFalse(q.isEmpty());
			assertTrue(q.peek().equals("test item"));
		}
		@Test 
		@DisplayName("enqueue when empty")
		void testEnqueueWhenEmpty2()
		{
			q2.enqueue("test item");
			assertTrue(q2.length()==1);
			assertFalse(q2.isEmpty());
			assertTrue(q2.peek().equals("test item"));
		}
		@Test 
		@DisplayName("length when empty")
		void testLengthWhenEmpty()
		{
			assertTrue(q.length()==0);
		}
		@Test 
		@DisplayName("length when empty")
		void testLengthWhenEmpty2()
		{
			assertTrue(q2.length()==0);
		}
		@AfterEach
		void destroy()
		{
			q.removeAll();
		}
		@AfterEach
		void destroy2()
		{
			q2.removeAll();
		}
	}
	@Nested
	@DisplayName("When item on queue")
	class WhenHasOne
	{
		@BeforeEach
		void testConstructor()
		{
			q=new Queue<String>();
			q.enqueue("test item");
		}
		@BeforeEach
		void testConstructor2()
		{
			q2=new Queue<String>(5);
			q2.enqueue("test item");
		}
		@Test
		@DisplayName("is not empty")
		void testIsEmptyWhenNotEmpty()
		{
			assertFalse(q.isEmpty());
		}
		@Test
		@DisplayName("is not empty")
		void testIsEmptyWhenNotEmpty2()
		{
			assertFalse(q2.isEmpty());
		}
		@Test
		@DisplayName("dequeue when not empty")
		void testDequeueWhenNotEmpty()
		{
			assertEquals("test item", q.dequeue());
		}
		@Test
		@DisplayName("dequeue when not empty")
		void testDequeueWhenNotEmpty2()
		{
			assertEquals("test item", q2.dequeue());
		}
		@Test 
		@DisplayName("peek when not empty")
		void testPeekWhenNotEmpty()
		{
			assertEquals("test item",q.peek());
		}
		@Test 
		@DisplayName("peek when not empty")
		void testPeekWhenNotEmpty2()
		{
			assertEquals("test item",q2.peek());	
		}
		@Test 
		@DisplayName("length when not empty")
		void testLengthWhenNotEmpty()
		{
			assertTrue(q.length()==1);
		}
		@Test 
		@DisplayName("length when not empty")
		void testLengthWhenNotEmpty2()
		{
			assertTrue(q2.length()==1);
		}
		@AfterEach
		void destroy()
		{
			q.removeAll();
		}
		@AfterEach
		void destroy2()
		{
			q2.removeAll();
		}
	}
	@Nested
	@DisplayName("When queue is full")
	class WhenQueueFull
	{
		@BeforeEach
		void testConstructor2()
		{
			q2=new Queue<String>(5);
			q2.enqueue("test item1");
			q2.enqueue("test item2");
			q2.enqueue("test item3");
			q2.enqueue("test item4");
			q2.enqueue("test item5");
		}
		@Test
		@DisplayName("enqueue when queue is full")
		void testEnqueueWhenFull()
		{
			assertThrows(Exception.class,()->{q2.enqueue("test item6");});
			fail("Failing test because no error thrown when enqueue a full queue");
		}
		@Test
		@DisplayName("is not empty")
		void testIsEmptyWhenFull2()
		{
			assertFalse(q2.isEmpty());
		}
		@Test
		@DisplayName("dequeue when not empty")
		void testDequeueWhenFull2()
		{
			assertEquals("test item1", q2.dequeue());
		}
		@Test 
		@DisplayName("peek when not empty")
		void testPeekWhenFull2()
		{
			assertEquals("test item1",q2.peek());	
		}
		@Test 
		@DisplayName("length when not empty")
		void testLengthWhenFull2()
		{
			assertTrue(q2.length()==5);
		}
		@AfterEach
		void destroy2()
		{
			q2.removeAll();
		}
	}
}