package net.fishear.samples.t5.srchgridform.components.persons;

import net.fishear.data.generic.services.GenericService;
import net.fishear.samples.t5.srchgridform.entities.Person;
import net.fishear.samples.t5.srchgridform.services.PersonService;
import net.fishear.web.t5.base.AbstractGrid;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.ioc.annotations.Inject;



@Import(stylesheet  = "PersonsList.css")
public class 
	PersonsList
extends
	AbstractGrid<Person>
{
	@Component
	private PersonSearch personSearch;

	@Inject
	private PersonService epSvc;

	@Component
	private PersonDetail personDetail;

	@Override
	public GenericService<Person> getService() {
		return epSvc;
	}

}