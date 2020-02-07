package uk.co.businessitsolution.ui.views.login;

import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.*;
import uk.co.businessitsolution.MainView;
import uk.co.businessitsolution.app.security.SecurityUtils;

@Route("login")
@PageTitle("bits2")
@JsModule("./styles/shared-styles.js")
//@Viewport(BakeryConst.VIEWPORT)
public class LoginView extends LoginOverlay
        implements AfterNavigationObserver, BeforeEnterObserver {

    public static final String ROUTE =  "login";

    public LoginView() {
        LoginI18n i18n = LoginI18n.createDefault();
        i18n.setHeader(new LoginI18n.Header());
        i18n.getHeader().setTitle("bits2");
        i18n.getHeader().setDescription(
                "admin@vaadin.com + admin\n" + "barista@vaadin.com + barista");
        i18n.setAdditionalInformation(null);
        i18n.setForm(new LoginI18n.Form());
        i18n.getForm().setSubmit("Sign in");
        i18n.getForm().setTitle("Sign in");
        i18n.getForm().setUsername("Email");
        i18n.getForm().setPassword("Password");
        setI18n(i18n);
        setForgotPasswordButtonVisible(false);
        setAction("login");
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (SecurityUtils.isUserLoggedIn()) {
            event.forwardTo(MainView.class);
        } else {
            setOpened(true);
        }
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        setError(
                event.getLocation().getQueryParameters().getParameters().containsKey(
                        "error"));
    }

}
