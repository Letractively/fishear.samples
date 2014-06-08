package net.fishear.samples.t5.srchgridform.pages;

import net.fishear.samples.t5.srchgridform.components.client.ClientDetailForm;
import net.fishear.web.services.EnvironmentService;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.ioc.annotations.Inject;



@Import(stylesheet = "Clients.css")
public class Clients
{

	@Component
	private ClientDetailForm clientList;
	
	@Inject
	private EnvironmentService envSvc;

	public String getRoleCodes() {
		return envSvc.getPropertyRemeber("admin.role.code", "");
	}
}
