package br.com.teste.atm.server.service.user;

import br.com.teste.atm.server.exception.user.UserAlreadExistException;
import br.com.teste.atm.server.exception.user.UserNotFoundException;
import br.com.teste.atm.server.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * This service provides CRUD operations for {@link User}
 * </p>
 *
 * @author murata
 * @project atm.server
 */
@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	/**
	 *
	 * @param user	User to be saved
	 * @return		new User
	 * @throws UserAlreadExistException
	 */
	@Transactional
	public User save(final User user) throws UserAlreadExistException {

		User userEntity = repository.findByUsername(user.getUsername());
		if(isUserExists(userEntity)) throw new UserAlreadExistException("Username already exists");

		repository.save(user);

		return user;
	}

	public void delete(final Long userId) throws UserNotFoundException {
		User userEntity = repository.findUserById(userId);
		if(!isUserExists(userEntity)) throw new UserNotFoundException("User not found");
		repository.delete(userEntity);
	}

	/**
	 * Retrieve all Users
	 * @return	User`s list
	 */
	public List<User> findAll() {
		return repository.findAll();
	}

	/**
	 * Retrive User by username
	 * @param username	username`s User
	 * @return			User
	 */
	public User findByUsername(final String username) {
		return repository.findByUsername(username);
	}

	/**
	 * Verify if user exists
	 * @param userEntity	user to be found
	 * @return				true if user exists
	 */
	private boolean isUserExists(final User userEntity) {
		return !Objects.isNull(userEntity);
	}

}
