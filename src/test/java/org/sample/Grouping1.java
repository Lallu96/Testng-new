package org.sample;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Grouping1 extends Base {
	Pojo1 p;
	@BeforeMethod
	private void browser() {
		launchBrowser();
		launchUrl("https://www.facebook.com/");

	}
	@Test(groups="reg")
	private void tc4() {
		System.out.println("text4");

	}
	@Test(groups="smoke")
	private void tc5() {
		System.out.println("text5");

	}
	@Test(groups="sanity")
	private void tc6() {
		System.out.println("text6");

	}


}
