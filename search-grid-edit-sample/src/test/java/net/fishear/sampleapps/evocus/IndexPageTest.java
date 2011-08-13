package net.fishear.sampleapps.evocus;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.util.List;

import net.fishear.samples.t5.srchgridform.services.AppModule;
import net.fishear.testsupport.t5.AbstractT5Test;
import net.fishear.web.rights.services.LoginLogoutService;

import org.apache.tapestry5.dom.Document;
import org.jaxen.JaxenException;
import org.testng.annotations.Test;

import com.formos.tapestry.testify.core.ForComponents;
import com.formos.tapestry.xpath.TapestryXPath;



public class 
	IndexPageTest
extends
	AbstractT5Test
{

	public IndexPageTest() {
		super(AppModule.class, "app");
	}

	@ForComponents
	public LoginLogoutService llSvc = mock(LoginLogoutService.class);

	@Test
	public void menuTest() throws JaxenException {
		when(llSvc.isLoggedIn()).thenReturn(true);
		doNothing().when(llSvc).checkRememberMe();

        Document doc = tester().renderPage("about");
        TapestryXPath xp1 = TapestryXPath.xpath("id('menu')//ul/li//a");
        List<String> list = xp1.selectElementsAttribute(doc, "href");
        for (String string : list) {
			System.err.println("  -> " + string);
		}
        assertEquals(
        	list.toArray(), 
        	new String[] {"/foo/","/foo/extpersons","/foo/admin", "/foo/about"},
    		"menu links does not match request"
        );
	}

	@Test(dependsOnMethods = "menuTest")
	public void aboutTest() throws JaxenException {

		when(llSvc.isLoggedIn()).thenReturn(true);
		doNothing().when(llSvc).checkRememberMe();

        Document doc = tester().renderPage("about");

        TapestryXPath xp2 = TapestryXPath.xpath("id('logout')");
        assertNotNull(xp2.selectSingleNode(doc), "Assume user is logged in, the 'logout' node is not presented");

		TapestryXPath xp3 = TapestryXPath.xpath("id('accountInfo')/a[@class='loginLink']");
		assertNull(xp3.selectSingleNode(doc), "Assume user is logged in, The 'login' node is presented");

	}

	@Test(dependsOnMethods = "aboutTest")
	public void loginTest() throws JaxenException {

		when(llSvc.isLoggedIn()).thenReturn(false);
		when(llSvc.isLoggedIn()).thenReturn(false);

        Document doc = tester().renderPage("index");

        TapestryXPath xp2 = TapestryXPath.xpath("id('logout')");
        assertNull(xp2.selectSingleNode(doc), "Assume user is not logged in, the 'logout' node is not presented");

		TapestryXPath xp3 = TapestryXPath.xpath("id('accountInfo')/a[@class='loginLink']");
		assertNotNull(xp3.selectSingleNode(doc), "Assume user is logged in, The 'login' node is presented");
	}

    public void doSetUp() {
//		when(llSvc.isLoggedIn()).thenReturn(true);
    }
}
