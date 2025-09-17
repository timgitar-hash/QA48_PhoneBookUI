package com.phonebook.tests;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.utils.Dataproviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class AddcontactTests extends Testbase {

	@BeforeMethod
	public void precondition() {
		if (!app.getUser().isLoginLinkPresent()){
			app.getUser().clickOnSingOutButton();
		}
		app.getUser().clickOnLoginLink();
		app.getUser().fillRegLogForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
		app.getUser().clickOnLoginButton();

	}

	@Test
	public void addContactPosTest() {
		app.getContact().clickOnAddLink();
		app.getContact().fillContactForm(new Contact()
				.setName(ContactData.NAME)
				.setLastname(ContactData.LASTNAME)
				.setPhone(ContactData.PHONE)
				.setEmail(ContactData.EMAIL)
				.setCity(ContactData.CITY)
				.setDescription(ContactData.DESCRIPTION));
		app.getContact().clickOnSaveButton();
		Assert.assertTrue(app.getContact().isContactAdded(ContactData.NAME));
	}


	@DataProvider
	public Iterator <Object[]>addNewContact(){
		List<Object[]>list = new ArrayList<>();
		list.add(new Object[]{"Alex","Kan","3423535432","kcan@gmail.com","NY","Friend"});
		list.add(new Object[]{"Alex","Kan","34357835432","kawn@gmail.com","NY","Friend"});
		list.add(new Object[]{"Alex","Kan","34353532432","kafn@gmail.com","NY","Friend"});
		return list.iterator();
	}
	@Test(dataProvider = "addNewContact" , dataProviderClass = Dataproviders.class)
	public void addContactPosFromDataProviderTest(String name ,
												  String lastName ,
												  String phone,
												  String email ,
												  String City ,
												  String Description) {

		app.getContact().clickOnAddLink();
		app.getContact().fillContactForm(new Contact()
				.setName(name)
				.setLastname(lastName)
				.setPhone(phone)
				.setEmail(email)
				.setCity(City)
				.setDescription(Description));
		app.getContact().clickOnSaveButton();
		Assert.assertTrue(app.getContact().isContactAdded(name));
	}

	@DataProvider(name = "addNewContactWithCSV")
	public Iterator<Object[]>addNewContactWithCSV () throws IOException {
		List<Object[]>list = new ArrayList<>();
		BufferedReader reader = new BufferedReader((new FileReader(new File("src/test/resources/Contact.csv"))));
		String line = reader.readLine();
		while (line!=null) {


			String[] split = line.split(",");
			list.add(new Object[]{new Contact().setName(split[0])
					.setLastname(split[1])
					.setPhone(split[2])
					.setEmail(split[3])
					.setCity(split[4])
					.setDescription(split[5])});
			line = reader.readLine();
		}

		return list.iterator();

	}
	@Test(dataProvider = "addNewContactWithCSV" ,dataProviderClass = Dataproviders.class)
	public void addContactPosFromDataProviderWithCSVFileTest(Contact contact) {

		app.getContact().clickOnAddLink();
		app.getContact().fillContactForm(contact);
		app.getContact().clickOnSaveButton();
		Assert.assertTrue(app.getContact().isContactAdded(contact.getName()));
	}

	@AfterMethod
	public void postCondition() {
		app.getContact().deleteContact();

	}

}
