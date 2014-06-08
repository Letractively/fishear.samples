package net.fishear.samples.t5.srchgridform.components.persons;


import java.util.Map;

import net.fishear.data.generic.services.GenericService;
import net.fishear.samples.t5.srchgridform.entities.Person;
import net.fishear.samples.t5.srchgridform.services.ClientService;
import net.fishear.samples.t5.srchgridform.services.PersonService;
import net.fishear.web.t5.base.AbstractDetailComponent;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.ioc.annotations.Inject;


@Import(stylesheet = "PersonDetail.css")
public class 
	PersonDetail
extends
	AbstractDetailComponent<Person>
{

	@Inject
	private ClientService clSvc;
	
	@Inject
	private PersonService personService;

	public Map<Object, String> getPersTypes() {
		return (Map<Object, String>) clSvc.getIdValueMap(null, "description");
	}

	@Override
	public GenericService<Person> getService() {
		return personService;
	}

	@Override
	protected void beforeSave(Person entity) {
		// TODO Auto-generated method stub
		
	}
	
}
