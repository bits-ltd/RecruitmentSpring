package uk.co.businessitsolution.ui.views.errors;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.*;
import uk.co.businessitsolution.MainView;

import javax.servlet.http.HttpServletResponse;

@ParentLayout(MainView.class)
@PageTitle("Page was not found")
@JsModule("./styles/shared-styles.js")
public class CustomRouteNotFoundError extends RouteNotFoundError {

	public CustomRouteNotFoundError() {
		RouterLink link = Component.from(
				ElementFactory.createRouterLink("", "Go to the front page."),
				RouterLink.class);
		getElement().appendChild(new Text("Oops you hit a 404. ").getElement(), link.getElement());
	}

	@Override
	public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<NotFoundException> parameter) {
		return HttpServletResponse.SC_NOT_FOUND;
	}
}
