package org.sample;

import org.testng.annotations.Test;

public class ParallelExe2 {
	@Test
	private void tc5() {
		System.out.println("test5" + Thread.currentThread().getId());

	}
	@Test
	private void tc6() {
		System.out.println("test6" + Thread.currentThread().getId());

	}
	@Test
	private void tc7() {
		System.out.println("test7" + Thread.currentThread().getId());

	}
	@Test
	private void tc8() {
		System.out.println("test8" + Thread.currentThread().getId());

	}


}
