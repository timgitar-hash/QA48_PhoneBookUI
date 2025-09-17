package com.phonebook.utils;

import com.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dataproviders {

	@DataProvider(name = "addNewContactWithCSV")
	public Iterator<Object[]> addNewContactWithCSV() throws IOException {
		List<Object[]> list = new ArrayList<>();
		BufferedReader reader = new BufferedReader((new FileReader(new File("src/test/resources/Contact.csv"))));
		String line = reader.readLine();
		while (line != null) {


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

	@DataProvider
	public Iterator <Object[]>addNewContact(){
		List<Object[]>list = new ArrayList<>();
		list.add(new Object[]{"Alex","Kan","3423535432","kcan@gmail.com","NY","Friend"});
		list.add(new Object[]{"Alex","Kan","34357835432","kawn@gmail.com","NY","Friend"});
		list.add(new Object[]{"Alex","Kan","34353532432","kafn@gmail.com","NY","Friend"});
		return list.iterator();}
}
