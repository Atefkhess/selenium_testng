package com.todos.tests;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.todos.pages.TodoPage;
import com.todos.utils.Setup;

public class AddToDoTest extends Setup {

	public AddToDoTest() throws IOException {
		super();
		
	}
 TodoPage todo;
@Test
public void todoInputOperation() throws IOException, InterruptedException {
	TodoPage page = new TodoPage();
	Thread.sleep(3000);
	page.todoInsert(prop.getProperty("todo1"),prop.getProperty("todo2"),prop.getProperty("todo3"));
	
	//Checking the text that I inserted is present 
	String elementTodo = todo.checkElementPresent(TodoPage.todoDone);
	Assert.assertTrue(elementTodo.contains(prop.getProperty("todo1")));
	
	//checking the checkbox is selected 
	boolean checkbox = todo.isCheckboxSelected(TodoPage.checkedBox);
	Assert.assertFalse(checkbox);
}
}
