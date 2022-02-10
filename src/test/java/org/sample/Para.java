package org.sample;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Para extends Base {
	Pojo1 p;

	@BeforeMethod
	private void browser() {
		launchBrowser();
		launchUrl("https://www.facebook.com/");

	}

	@Parameters({"Username","Password"})
	@Test
	private void tc1(String user, String pass) {
		p = new Pojo1();
		passText(p.getTxtEmail(),user);
		passText(p.getTxtPass(),pass);
	}
	
	@AfterMethod
	private void quit() {
		browserClose();

	}

}
