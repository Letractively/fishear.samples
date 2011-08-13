package net.fishear.sampleapps.evocus.components.persons;


import java.util.Map;

import net.fishear.data.generic.services.GenericService;
import net.fishear.sampleapps.evocus.entities.Person;
import net.fishear.sampleapps.evocus.services.ClientService;
import net.fishear.sampleapps.evocus.services.PersonService;
import net.fishear.web.t5.components.AbstractFormComponent;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.ioc.annotations.Inject;


@Import(stylesheet = "DetailForm.css")
public class 
	DetailForm
extends
	AbstractFormComponent<Person>
{

	@Inject
	private ClientService clSvc;
	
	@Inject
	private PersonService epSvc;

	public Map<Object, String> getPersTypes() {
		return clSvc.getIdValueMap(null, "description");
	}

	@Override
	public GenericService<Person> getService() {
		return epSvc;
	}
	
}
