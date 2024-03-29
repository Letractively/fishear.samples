package net.fishear.samples.t5.srchgridform.pages;

import net.fishear.samples.t5.srchgridform.services.PersonService;
import net.fishear.web.t5.base.AbstractComponent;
import net.fishear.web.t5.components.Messages;

import org.apache.tapestry5.annotations.InjectComponent;



public abstract class 
	AbstractDatabasePage
extends 
	AbstractComponent
{

	@InjectComponent
	private Messages messages;

	public abstract PersonService getDataService();

	public void setMessageText(String s) {
		messages.setText(s);
	}

	public void setErrorText(String s) {
		messages.setError(s);
	}
}
