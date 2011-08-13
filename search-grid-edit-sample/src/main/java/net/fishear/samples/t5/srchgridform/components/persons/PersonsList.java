package net.fishear.samples.t5.srchgridform.components.persons;

import net.fishear.data.generic.services.GenericService;
import net.fishear.samples.t5.srchgridform.entities.Person;
import net.fishear.samples.t5.srchgridform.services.PersonService;
import net.fishear.web.t5.components.AbstractGrid;
import net.fishear.web.t5.components.Messages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;



@Import(stylesheet  = "PersonsList.css")
public class 
	PersonsList
extends
	AbstractGrid<Person>
{
	@Component
	private DataSearch dataSearch;

	@Inject
	private PersonService epSvc;
	
	@Component
	private DetailForm detailForm;

	@Property 
	private Person current;

	@InjectComponent
	private Messages messages;

	@Override
	public GenericService<Person> getService() {
		return epSvc;
	}

}