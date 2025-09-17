package com.phonebook.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MyListener implements WebDriverListener {
	@Override
	public void beforeFindElement(WebDriver driver, By locator) {
		WebDriverListener.super.beforeFindElement(driver, locator);
		logger.info("The loc will find"+ locator );
		logger.info("_______________");
	}

	@Override
	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
		WebDriverListener.super.afterFindElement(driver, locator, result);
		logger.info("The loc is "+ locator);
		logger.info("---------------------");
	}

	@Override
	public void beforeFindElements(WebDriver driver, By locator) {
		WebDriverListener.super.beforeFindElements(driver, locator);
		logger.info("Before find elements" + locator);
		logger.info("_________");
	}

	@Override
	public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
		WebDriverListener.super.afterFindElements(driver, locator, result);
		logger.info("List zise is "+ result.size());
		logger.info("---------------------");
	}

	@Override
	public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
		WebDriverListener.super.onError(target, method, args, e);
		logger.info("test have a problem");
		logger.info("++++++++");

		logger.info("Method -->" + method.getName());
		logger.info("+++++++++++++==");

		logger.info("TargetExpeption" + e.getTargetException());
		logger.info("++++++++");

		logger.info("Object target-->" + target.toString());
		logger.info("++++++++++++++");
	}

	@Override
	public void beforeQuit(WebDriver driver) {
		WebDriverListener.super.beforeQuit(driver);
	}

	@Override
	public void afterQuit(WebDriver driver) {
		WebDriverListener.super.afterQuit(driver);
	}

	Logger logger = LoggerFactory.getLogger(MyListener.class);
}
