package test.white;

import engine.Clock;

/**
 * 
 * @author alex
 *	Class for test the clock.
 */
public class ClockTest {
	public static void main(String[] args) {
		Clock clock = new Clock(1000);
		clock.start();
	}

}
