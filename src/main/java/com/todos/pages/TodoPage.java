package com.todos.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.todos.utils.BasePage;

public class TodoPage extends BasePage {

	public TodoPage() throws IOException {

		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@placeholder='What needs to be done?']")
	public static WebElement todoChamp;
	@FindBy(how = How.XPATH, using = "//label[normalize-space()='Adopter des bonnes pratique de test']")
	public static WebElement todoDone;
	@FindBy(how = How.XPATH, using = "//input[@ng-model='todo.completed']")
	public static WebElement checkedBox;
	@FindBy(how = How.XPATH, using = "//button[@class='clear-completed']")
	public static WebElement remobeBTN;

	public void insertToDo(String todoInput) {
		todoChamp.sendKeys(todoInput);
		todoChamp.sendKeys(Keys.ENTER);
	}
	public void todoInsert(String todoInput, String todoInput1, String todoInput2) {
		try {

			// Check if todoChamp is not null

			assert todoChamp != null : "todoChamp is null";
			todoChamp.sendKeys(todoInput);
			todoChamp.submit();
			todoChamp.sendKeys(todoInput1);
			todoChamp.submit();
			todoChamp.sendKeys(todoInput2);
			todoChamp.submit();
			todoDone.isEnabled();
		} catch (Exception e) {
			System.out.println("Exceptions caught" + e.getMessage());
		}
	}

	public String checkElementPresent(WebElement element) {
		String elementToDo = element.getText();
		return elementToDo;

	}

	public boolean isCheckboxSelected(WebElement element) {
		boolean isCheckboxSelected = element.isSelected();
		return isCheckboxSelected;
	}

	public String getPageSource() {
		String element = driver.getPageSource();
		return element;
	}

	public void clickOnElement(WebElement element) {
		element.click();

	}

}
