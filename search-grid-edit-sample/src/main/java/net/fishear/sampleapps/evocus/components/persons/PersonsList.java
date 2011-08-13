package net.fishear.sampleapps.evocus.components.persons;

import net.fishear.data.generic.services.GenericService;
import net.fishear.sampleapps.evocus.entities.Person;
import net.fishear.sampleapps.evocus.services.PersonService;
import net.fishear.web.t5.components.AbstractGridComponent;
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
	AbstractGridComponent<Person>
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

	@CommitAfter
	public void onActionFromEdit(Long id) {
		detailForm.load(id);
	}

	@Override
	public GenericService<Person> getService() {
		return epSvc;
	}

}