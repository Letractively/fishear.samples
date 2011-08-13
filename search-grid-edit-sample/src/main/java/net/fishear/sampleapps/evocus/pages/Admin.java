package net.fishear.sampleapps.evocus.pages;

import net.fishear.sampleapps.evocus.components.admin.ClientList;
import net.fishear.web.services.EnvironmentService;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.ioc.annotations.Inject;



@Import(stylesheet = "Admin.css")
public class Admin
{

	@Component
	private ClientList persTypeCodeList;
	
	@Inject
	private EnvironmentService envSvc;

	public String getRoleCodes() {
		return envSvc.getPropertyRemeber("admin.role.code", "");
	}
}
