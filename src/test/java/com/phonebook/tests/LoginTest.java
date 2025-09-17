package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Testbase {

	@BeforeMethod
	public void ensurePrecondition(){
		if (!app.getUser().isLoginLinkPresent()){
			app.getUser().clickOnSingOutButton();
		}
	}
    @Test(priority = 1)
    public void loginPositiveTest() {
		app.getUser().clickOnLoginLink();
		app.getUser().fillRegLogForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
		app.getUser().clickOnRegButton();
//		Assert.assertTrue(app.getUser().isSignOutPresent());
	}

		@Test(priority = 2)
    public void loginNegTest(){
		app.getUser().clickOnLoginLink();
		app.getUser().fillRegLogForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
		app.getUser().clickOnLoginButton();
//		Assert.assertTrue(app.getUser().isAlertDisplayed());

	}


}
