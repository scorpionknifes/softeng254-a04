package se254.a4.t2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import se254.a4.t1.Counter;

/**
 * Test class for Counter class
 * @author Author Name: Cheng-Zhen Yang Author UPI: cyan562
 * @version Date: 29/10/2020
 *
 */
class CounterTest {

	/**
     * Test method for {@link se254.a4.t1.Counter#increment()}.
     */
    @Test
    void testIncrement() {
        Counter counter = new Counter();
		counter._ctr = 0;
		
		counter.increment();
		
		assertEquals(1, counter._ctr);
    }

    /**
     * Test method for {@link se254.a4.t1.Counter#decrement()}.
     */
    @Test
    void testDecrement() {
        Counter counter = new Counter();
		counter._ctr = 1;
		
		counter.decrement();
		
		assertEquals(0, counter._ctr);
    }

    /**
     * Test method for {@link se254.a4.t1.Counter#reset()}.
     */
    @Test
    void testReset() {
        Counter counter = new Counter();
        counter._ctr = 10;
		
		counter.reset();
		
		assertEquals(0, counter._ctr);
    }

    /**
     * Test method for {@link se254.a4.t1.Counter#multiplyBy(int)}.
     */
    @Test
    void testMultiplyBy() {
        Counter counter = new Counter();
		counter._ctr = 10;
		
		counter.multiplyBy(10);
		
		assertEquals(100, counter._ctr);
    }
}
