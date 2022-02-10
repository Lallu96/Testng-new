package org.sample;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Grouping extends Base{
	Pojo1 p;
	@BeforeMethod
	private void browser() {
		launchBrowser();
		launchUrl("https://www.facebook.com/");

	}
	@Test(groups="smoke")
	private void tc1() {
		System.out.println("text1");

	}
	@Test(groups="sanity")
	private void tc2() {
		System.out.println("text2");

	}
	@Test(groups="reg")
	private void tc3() {
		System.out.println("text3");

	}


}
