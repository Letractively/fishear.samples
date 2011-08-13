package net.fishear.samples.t5.login.pages;

import javax.security.auth.login.LoginContext;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;

import net.fishear.web.rights.t5.components.AccountInfo;
import net.fishear.web.rights.t5.components.LoginForm;

public class LoginPage
{

	@Component
	@Property
	private LoginForm loginForm;

	void onActionFromLogout() {
		loginForm.performLogout();
	}
	
}
