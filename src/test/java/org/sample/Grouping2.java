package org.sample;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Grouping2 extends Base {
	Pojo1 p;
	@BeforeMethod
	private void browser() {
		launchBrowser();
		launchUrl("https://www.facebook.com/");

	}
	
	@Test(groups="smoke")
	private void tc7() {
		System.out.println("text7");

	}
	@Test(groups="reg,smoke")
	private void tc8() {
		System.out.println("text8");

	}
	@Test(groups="smoke")
	private void tc9() {
		System.out.println("text9");

	}
	@Test(groups="sanity")
	private void tc10() {
		System.out.println("text10");

	}


}
