package org.sample;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataPro extends Base {
	Pojo1 p;

	@BeforeMethod
	private void browser() {
		launchBrowser();
		launchUrl("https://www.facebook.com/");

	}

	@DataProvider(name = "credentials")
	private Object[][] allDatas() {
		return new Object[][] { { "ganesh", "43646" }, { "lalith", "8566" }, { "sanju", "6868" }

		};
	}

	@Test(dataProvider = "credentials")
	private void tc3(String user, String pass) {
		p = new Pojo1();
		passText(p.getTxtEmail(), user);
		passText(p.getTxtPass(), pass);

	}

}
