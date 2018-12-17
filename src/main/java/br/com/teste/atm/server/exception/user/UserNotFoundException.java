package br.com.teste.atm.server.exception.user;

/**
 * @author Alexandre Murata on 17/12/18.
 * @project atm.server
 */
public class UserNotFoundException extends Exception {

	public UserNotFoundException(final String message) {
		super(message);
	}
}
