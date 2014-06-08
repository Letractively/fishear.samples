package net.fishear.samples.t5.srchgridform.components.client;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.ioc.annotations.Inject;

import net.fishear.samples.t5.srchgridform.entities.Client;
import net.fishear.samples.t5.srchgridform.entities.Person;
import net.fishear.samples.t5.srchgridform.services.ClientService;
import net.fishear.samples.t5.srchgridform.services.PersonService;
import net.fishear.web.t5.base.AbstractGridDetailComponent;


@Import(stylesheet = "ClientDetailForm.css")
public class 
	ClientDetailForm
extends
	AbstractGridDetailComponent<Client>
{

	@Inject
	ClientService clientService;

	@Inject
	PersonService personService;
	
	@Override
	public ClientService getService() {
		return clientService;
	}

	@Override
	protected void newEntityInstance(Client entity) {
		entity.setPerson(personService.newEntityInstance());
	}
	
	@Override
	protected void beforeSave(Client entity) {
		personService.save(entity.getPerson());
	}

}
