package net.fishear.samples.t5.srchgridform.components.layout;

import net.fishear.samples.t5.srchgridform.pages.Clients;
import net.fishear.samples.t5.srchgridform.pages.ExtPersons;
import net.fishear.samples.t5.srchgridform.pages.Index;
import net.fishear.samples.t5.srchgridform.pages.about.About;
import net.fishear.utils.Texts;
import net.fishear.web.rights.t5.components.AccountInfo;
import net.fishear.web.rights.t5.components.LoginForm;
import net.fishear.web.t5.base.ComponentBase;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;


/**
 * Layout component for pages of application Person app.
 */
@Import( stylesheet = {
			"context:layout/layout.css"
//			, JQUERY_BASE + "/jquery-ui/themes/base/jquery.ui.all.css"
		}
//		, library = {
//			JQUERY_BASE + "/" + JQUERY_FILE,
//	        JQUERY_BASE + "/jquery-noconflict.js",
////	        JQUUI_BASE + "/external/jquery.bgiframe-2.1.1.js",
//	        JQUUI_BASE + "/js/jquery-ui.min.js",
//	        JQUUI_BASE + "/js/jquery-ui-i18n.js",
////	        JQUERY_BASE + "/clearfield.js",
//	        JQUERY_BASE + "/fg.menu/fg.menu.js",
////	        JQUERY_BASE + "/jquery.scrollTo-1.4.2.js",
//	        JQUERY_BASE + "/jquery.cookies.min.js",
//	        "Layout.js"
//	}
)
@SuppressWarnings("unused")
public class
	Layout
extends
	ComponentBase
{
    /** The page title, for the <title> element and the <h1> element. */
	@Property
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String title;

    @Property @Parameter(allowNull = false, defaultPrefix = BindingConstants.LITERAL, value="message:personal-managemant-label")
    private String subtitle;

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String sidebarTitle;

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private Block sidebar;

    @Component
    private LoginForm loginForm;
    
    @Component
    private AccountInfo accountInfo;

 	@Inject
    private JavaScriptSupport rsup;
    
    @Inject
    private Request request;
    
    @Inject
    private ComponentResources crsc;
    
    @Inject
    private PageRenderLinkSource prsc;
    
    public String getAppTitle() {
    	return Texts.tos(translate("application-name"), " - ", subtitle);
    }

    public String getPageTitle() {
    	return crsc.getMessages().format(menuItem.getLabel()+"-label");
    }
    
    public String getPageUrl() {
    	return prsc.createPageRenderLink(menuItem.getPageClass()).toAbsoluteURI();
    }
    
    public String getClassForPageName()
    {
      return crsc.getPage().getClass().equals(menuItem.getPageClass())
             ? "current_page_item"
             : null;
    }

    @Property
    private MenuItem menuItem;
    
    public MenuItem[] getMenuItems() {
    	return new MenuItem[] {
        		new MenuItem(Index.class, "index"),
        		new MenuItem(ExtPersons.class, "Extpersons"),
        		new MenuItem(Clients.class, "clients"),
        		new MenuItem(About.class, "about")
    	};
    }
    
    public static class MenuItem {
    	
    	private Class<?> pageClass;
    	
    	private String label;

		public MenuItem(Class<?> pageClass, String label) {
			super();
			this.pageClass = pageClass;
			this.label = label;
		}

		public Class<?> getPageClass() {
			return pageClass;
		}

		public void setPageClass(Class<?> pageClass) {
			this.pageClass = pageClass;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}
    	
    }
}
