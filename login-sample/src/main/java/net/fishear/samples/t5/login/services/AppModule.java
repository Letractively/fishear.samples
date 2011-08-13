package net.fishear.samples.t5.login.services;

import net.fishear.web.rights.services.LoginLogoutService;
import net.fishear.web.rights.services.impl.DummyLoginLogoutService;
import net.fishear.web.services.AppPropertiesService;
import net.fishear.web.services.EnvironmentService;
import net.fishear.web.services.impl.EnvironmentServiceImpl;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;


/**
 * This module is automatically included as part of the Tapestry IoC Registry,
 * it's a good place to configure and extend Tapestry, or to place your own
 * service definitions.
 */
public class AppModule
{
	public static void bind(ServiceBinder binder) {
		
//		binder.bind(AppPropertiesService.class);
		binder.bind(LoginLogoutService.class, DummyLoginLogoutService.class);
	}

	public static void contributeApplicationDefaults(MappedConfiguration<String, String> configuration) {

		configuration.add(SymbolConstants.SUPPORTED_LOCALES, "cz,en");

		configuration.add(SymbolConstants.PRODUCTION_MODE, "false");

		configuration.add(SymbolConstants.APPLICATION_VERSION, "0.0.1-SNAPSHOT");
		
        configuration.add(SymbolConstants.COMPRESS_WHITESPACE, "false");

        configuration.add(SymbolConstants.SUPPRESS_REDIRECT_FROM_ACTION_REQUESTS, "true");

        configuration.add(SymbolConstants.GZIP_COMPRESSION_ENABLED, "false");
        
//      configuration.add(SymbolConstants.EXCEPTION_REPORT_PAGE, "errors/Index");
	}
}
