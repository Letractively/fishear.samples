package net.fishear.sampleapps.evocus.services;

import net.fishear.data.generic.entities.EntityI;
import net.fishear.sampleapps.evocus.entities.Client;
import net.fishear.sampleapps.evocus.entities.Person;
import net.fishear.t5.hibernate.FishearHibernateModule;
import net.fishear.web.rights.services.LoginLogoutService;
import net.fishear.web.rights.services.impl.DummyLoginLogoutService;
import net.fishear.web.rights.t5.FishearRightsModule;
import net.fishear.web.services.AppPropertiesService;
import net.fishear.web.services.EnvironmentService;
import net.fishear.web.services.impl.EnvironmentServiceImpl;
import net.fishear.web.t5.FishearCoreModule;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.SubModule;


/**
 * This module is automatically included as part of the Tapestry IoC Registry,
 * it's a good place to configure and extend Tapestry, or to place your own
 * service definitions.
 */
@SubModule({FishearCoreModule.class, FishearHibernateModule.class, FishearRightsModule.class})
public class AppModule
{
	public static void bind(ServiceBinder binder) {
		
		binder.bind(PersonService.class);
		binder.bind(ClientService.class);
		binder.bind(AppPropertiesService.class);
		binder.bind(LoginLogoutService.class, DummyLoginLogoutService.class);
		binder.bind(EnvironmentService.class, EnvironmentServiceImpl.class);
		
		bindGenericServices(binder, Person.class, Client.class);
	}

	private static void bindGenericServices(ServiceBinder binder, Class<? extends EntityI<?>>... forEntitties) {

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
