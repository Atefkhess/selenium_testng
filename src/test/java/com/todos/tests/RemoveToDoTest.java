package com.todos.tests;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.todos.pages.TodoPage;
import com.todos.utils.Setup;


public class RemoveToDoTest extends Setup {

	public RemoveToDoTest() throws IOException {
		super();
		
	}
 TodoPage todo;
 
 @Test
 public void iRemoveToDo() throws IOException, InterruptedException{
	 
	 todo = new TodoPage();
	 Thread.sleep(3000);
	 todo.insertToDo(prop.getProperty("todo1"));
	 Thread.sleep(3000);
	 todo.clickOnElement(TodoPage.checkedBox);
	 todo.clickOnElement(TodoPage.remobeBTN);
	 String pagesource = todo.getPageSource();
	 Assert.assertFalse(pagesource.contains(prop.getProperty("todo1")));
	 }
 }