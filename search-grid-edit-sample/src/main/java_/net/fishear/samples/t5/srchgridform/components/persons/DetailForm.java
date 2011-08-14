package net.fishear.samples.t5.srchgridform.components.persons;


import java.util.Map;

import net.fishear.data.generic.services.GenericService;
import net.fishear.samples.t5.srchgridform.entities.Person;
import net.fishear.samples.t5.srchgridform.services.ClientService;
import net.fishear.samples.t5.srchgridform.services.PersonService;
import net.fishear.web.t5.components.AbstractForm;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.ioc.annotations.Inject;


@Import(stylesheet = "DetailForm.css")
public class 
	DetailForm
extends
	AbstractForm<Person>
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
