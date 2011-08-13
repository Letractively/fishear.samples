package net.fishear.sampleapps.evocus.pages;


import net.fishear.sampleapps.evocus.components.persons.PersonsList;
import net.fishear.web.services.EnvironmentService;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.ioc.annotations.Inject;



//@Import(stylesheet  = "PersonsList.css")
@SuppressWarnings("unused")
public class 
	ExtPersons
{

	@Component(id = "persons")
	private PersonsList persons;

	@Inject
	private EnvironmentService envSvc;

	public String getRoleCodes() {
		return envSvc.getPropertyRemeber("edit.role", "");
	}

}