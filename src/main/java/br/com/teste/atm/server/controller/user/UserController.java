package br.com.teste.atm.server.controller.user;

import br.com.teste.atm.server.exception.user.UserAlreadExistException;
import br.com.teste.atm.server.exception.user.UserNotFoundException;
import br.com.teste.atm.server.model.user.User;
import br.com.teste.atm.server.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *     This controller provides the API that is used to perform CRUD operations for
 *     {@link User}
 * </p>
 * @author murata
 * @project atm.server
 */
@RestController
public class UserController {

	@Autowired
	private UserService service;

	/**
	 * Create a new user
	 * @param user	User to be saved
	 * @return		ResponseEntity
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<User> save(@RequestBody User user) {
		try{
			service.save(user);
		} catch(UserAlreadExistException e) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		return new ResponseEntity(HttpStatus.CREATED);
	}

	/**
	 * Edit user
	 * @param user	User to be edited
	 * @return		ResponseEntity
	 */
	@RequestMapping(path = "/user", method = RequestMethod.PUT)
	public ResponseEntity<User> edit(@RequestBody final User user) {

		User currentUser = null;
		try{
			service.update(user);
		} catch(UserNotFoundException e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(currentUser, HttpStatus.OK);
	}

	/**
	 * Delete user
	 * @param id	id`s User to be deleted
	 * @return		ResponseEntity
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> delete(@PathVariable("id") final Long id) {
		try {
			service.delete(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch(UserNotFoundException e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Retrieve all Users
	 * @return ReponseEntity
	 */
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		List<User> users = service.findAll();
		if(users.isEmpty()){
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(users, HttpStatus.OK);
	}

	//TODO: findById
	//TODO; findByUsername
}
