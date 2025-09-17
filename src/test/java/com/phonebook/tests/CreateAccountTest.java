package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTest extends Testbase{
	SoftAssert softAssert = new SoftAssert();
	@BeforeMethod
	public void ensurePrecondition(){
		if (!app.getUser().isLoginLinkPresent()){
	app.getUser().clickOnSingOutButton();
		}
	}

	@Test
	public void newUserRegistrationPositiveTest(){
		app.getUser().clickOnLoginLink();
		app.getUser().fillRegLogForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
		app.getUser().clickOnRegButton();
//		Assert.assertTrue(app.getUser().isSignOutPresent());
	}

	@Test
	public void existedUserRegistrationNegativeTest(){
		app.getUser().clickOnLoginLink();
		app.getUser().fillRegLogForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
		app.getUser().clickOnRegButton();
		softAssert.assertTrue((app.getUser().isAlertDisplayed()));
		softAssert.assertTrue(app.getUser().isErrorMessagePresent());
		softAssert.assertAll();


	}

}