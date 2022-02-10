package org.sample;

import org.testng.annotations.Test;

public class Tasks1 {
	@Test(priority=-3)
	private void tc1() {
		System.out.println("test");

	}
	@Test(priority=55,invocationCount=10)
	private void tc2() {
		System.out.println("test");

	}
	@Test(priority=2,enabled=false)
	private void tc3() {
		System.out.println("test");

	}
	@Test(priority=25)
	private void tc4() {
		System.out.println("test");

	}

}
