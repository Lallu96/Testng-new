package org.sample;

import org.testng.annotations.Test;

public class ReRun extends Base {
	
	@Test(retryAnalyzer=ReRunFailed.class)
	private void tc1() {
		System.out.println("test1");

	}
	@Test
	private void tc2() {
		System.out.println(5/0);
	
		

	}
	@Test
	private void tc3() {
		System.out.println("failed test3");
		

	}
	
	

}
