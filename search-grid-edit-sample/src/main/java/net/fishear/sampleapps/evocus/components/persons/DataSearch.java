package net.fishear.sampleapps.evocus.components.persons;

import net.fishear.sampleapps.evocus.entities.Person;
import net.fishear.sampleapps.evocus.services.PersonService;
import net.fishear.web.t5.components.AbstractSearchComponent;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.ioc.annotations.Inject;




@Import(stylesheet = "DataSearch.css")
public class 
	DataSearch
extends
	AbstractSearchComponent<Person>
{
	@Inject
	private PersonService epSvc;

	public PersonService getService() {
		return epSvc;
	}
}
