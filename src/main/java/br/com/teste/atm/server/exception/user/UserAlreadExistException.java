package br.com.teste.atm.server.exception.user;

/**
 * @author Alexandre Murata
 * @project atm.server
 */
public class UserAlreadExistException extends Exception {

	public UserAlreadExistException(String message) {
		super(message);
	}
}
