package com.phonebook.fw;

import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {



	public UserHelper(WebDriver driver) {
		super(driver);
	}

	public void clickOnRegButton() {
		click(By.name("registration"));
	}

	public void fillRegLogForm(User user) {
		type(By.name("email"), user.getEmail());
		type(By.name("password"), user.getPassword());
	}

	public void clickOnLoginLink() {
		click(By.cssSelector("[href='/login']"));
	}

	public boolean isSignOutPresent() {
		return isElementPresent(By.xpath("//button[.='Sign Out']"));
	}

	public void clickOnLoginButton() {
		click(By.name("login"));
	}

	public boolean isErrorMessagePresent() {
		return isElementPresent(By.cssSelector(".login_login__3EHKB>div"));
	}

	public void clickOnSingOutButton() {
		click(By.xpath("//button[.='Sign Out']"));

	}
	public boolean isLoginLinkPresent(){
		return isElementPresent(By.cssSelector("[href='/login']"));
	}
}
