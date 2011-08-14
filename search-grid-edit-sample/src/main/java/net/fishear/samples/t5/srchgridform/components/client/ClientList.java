package net.fishear.samples.t5.srchgridform.components.client;

import net.fishear.samples.t5.srchgridform.entities.Client;
import net.fishear.web.t5.components.AbstractGrid;
import net.fishear.web.t5.components.Messages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;



@Import(stylesheet = "ClientList.css")
public class 
	ClientList
extends
	AbstractGrid<Client>
{
	@SuppressWarnings("unused")
	@InjectComponent
	private Messages messages;

	@SuppressWarnings("unused")
	@Component
	private ClientDetailForm detailForm;

}
