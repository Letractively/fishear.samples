package net.fishear.samples.t5.srchgridform.components.admin;

import net.fishear.data.generic.services.GenericService;
import net.fishear.samples.t5.srchgridform.entities.Client;
import net.fishear.samples.t5.srchgridform.services.ClientService;
import net.fishear.web.t5.components.AbstractForm;
import net.fishear.web.t5.components.AbstractGrid;
import net.fishear.web.t5.components.Messages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;



@Import(stylesheet = "ClientList.css")
public class 
	ClientList
extends
	AbstractGrid<Client>
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
