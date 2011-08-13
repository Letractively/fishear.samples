package net.fishear.sampleapps.evocus.components.admin;

import net.fishear.data.generic.services.GenericService;
import net.fishear.sampleapps.evocus.entities.Client;
import net.fishear.sampleapps.evocus.services.ClientService;
import net.fishear.web.t5.components.AbstractGridComponent;
import net.fishear.web.t5.components.Messages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;



@Import(stylesheet = "ClientList.css")
public class 
	ClientList
extends
	AbstractGridComponent<Client>
{
	@InjectComponent
	private Messages messages;

	@Inject @Property
	private ClientService ptSvc;

	@Component
	private ClientDetailForm detailForm;
	
	@Property
	private Client row;

	@Override
	public GenericService<Client> getService() {
		return ptSvc;
	}

}
