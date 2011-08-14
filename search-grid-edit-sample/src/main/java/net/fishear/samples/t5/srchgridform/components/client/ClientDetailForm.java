package net.fishear.samples.t5.srchgridform.components.client;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.ioc.annotations.Inject;

import net.fishear.samples.t5.srchgridform.entities.Client;
import net.fishear.samples.t5.srchgridform.entities.Person;
import net.fishear.samples.t5.srchgridform.services.ClientService;
import net.fishear.samples.t5.srchgridform.services.PersonService;
import net.fishear.web.t5.components.AbstractForm;


@Import(stylesheet = "ClientDetailForm.css")
public class 
	ClientDetailForm
extends
	AbstractForm<Client>
{

	@Inject
	private ClientService clientService;
	
	@Inject
	private PersonService persSvc;
	
	@Override
	public ClientService getService() {
		return clientService;
	}

	protected void prepareNewEntity(Client entity) {
		entity.setPerson(new Person());
	}

	protected void beforeSave(Client entity) {
		persSvc.save(entity.getPerson());
	}

}
