package net.fishear.sampleapps.evocus.components.admin;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.ioc.annotations.Inject;

import net.fishear.sampleapps.evocus.entities.Client;
import net.fishear.sampleapps.evocus.entities.Person;
import net.fishear.sampleapps.evocus.services.ClientService;
import net.fishear.sampleapps.evocus.services.PersonService;
import net.fishear.web.t5.components.AbstractFormComponent;


@Import(stylesheet = "ClientDetailForm.css")
public class 
	ClientDetailForm
extends
	AbstractFormComponent<Client>
{

	@Inject
	private ClientService ptSvc;
	
	@Inject
	private PersonService persSvc;
	
	@Override
	public ClientService getService() {
		return ptSvc;
	}

	protected void prepareNewEntity(Client entity) {
		entity.setPerson(new Person());
	}

	protected void beforeSave(Client entity) {
		persSvc.save(entity.getPerson());
	}

}
