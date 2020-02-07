package uk.co.businessitsolution.app.security;


import uk.co.businessitsolution.backend.entity.User;

@FunctionalInterface
public interface CurrentUser {

	User getUser();
}
