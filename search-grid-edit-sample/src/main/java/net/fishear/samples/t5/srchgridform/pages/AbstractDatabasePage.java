package net.fishear.samples.t5.srchgridform.pages;

import net.fishear.samples.t5.srchgridform.services.PersonService;
import net.fishear.web.t5.base.ComponentBase;

import org.apache.tapestry5.annotations.InjectComponent;



public abstract class 
	AbstractDatabasePage
extends 
	ComponentBase
{

	public abstract PersonService getDataService();

}
