package org.sample;

import org.testng.annotations.Test;

public class ParallelExe  {
	
	@Test
	private void tc1() {
		System.out.println("test1" + Thread.currentThread().getId());

	}
	@Test
	private void tc2() {
		System.out.println("test2" + Thread.currentThread().getId());

	}
	@Test
	private void tc3() {
		System.out.println("test3" + Thread.currentThread().getId());

	}
	@Test
	private void tc4() {
		System.out.println("test4" + Thread.currentThread().getId());

	}

}
