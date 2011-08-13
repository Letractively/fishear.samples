package net.fishear.samples.t5.srchgridform.components.persons;

import net.fishear.samples.t5.srchgridform.entities.Person;
import net.fishear.samples.t5.srchgridform.services.PersonService;
import net.fishear.web.t5.components.AbstractSearch;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.ioc.annotations.Inject;




@Import(stylesheet = "DataSearch.css")
public class 
	DataSearch
extends
	AbstractSearch<Person>
{
	@Inject
	private PersonService epSvc;

	public PersonService getService() {
		return epSvc;
	}
}
