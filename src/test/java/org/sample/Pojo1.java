package org.sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojo1 extends Base {
	public Pojo1() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "email")
	private WebElement txtEmail;
	
	@FindBy(name = "pass")
	private WebElement txtPass;
	
	@FindBy(name = "login")
	private WebElement btnLogin;

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

}

