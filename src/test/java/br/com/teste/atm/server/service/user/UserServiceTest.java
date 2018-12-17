package br.com.teste.atm.server.service.user;

import br.com.teste.atm.server.exception.user.UserAlreadExistException;
import br.com.teste.atm.server.exception.user.UserNotFoundException;
import br.com.teste.atm.server.model.account.Account;
import br.com.teste.atm.server.model.user.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

/**
 * @author murata
 * @project atm.server
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@WebAppConfiguration
public class UserServiceTest {

	@Autowired
	private UserService service;

	private User user;

	private User user2;

	private Account account;

	private Account account2;

	@Before
	public void setUp() throws Exception {
		account = new Account();
		user = new User();


		account.setId(1L);
		account.setBalance(10000D);

		user.setId(1L);
		user.setUsername("ayoshiom");
		user.setPassword("Embraer190");
		user.setAccount(account);
	}

	@Test
	public void save() throws UserAlreadExistException {

		User response = service.save(user);
		Assert.assertNotNull(response);
	}

	@Test(expected = UserAlreadExistException.class)
	public void saveUserAlreadyExist() throws UserAlreadExistException {
		User u = service.save(user);
		User response2 = service.save(new User(3L, "ayoshiom", "123", account));
		Assert.fail();
	}

	//@Test
	public void update() throws UserNotFoundException, UserAlreadExistException {
		User u = service.save(user);
		User edited = user;
		edited.setUsername("rralmei");
		User response = service.update(edited);
		Assert.assertEquals("rralmei", response.getUsername());
	}

	//@Test(expected = UserNotFoundException.class)
	public void updateUserNotFound() throws UserNotFoundException, UserAlreadExistException {
		User u = service.save(user);
		User edited = new User(3L, "rralmei", "123456", account);
		edited.setUsername("rralmei");
		User response = service.update(edited);
	}

	@Test
	public void delete() throws UserNotFoundException, UserAlreadExistException {
		User u = service.save(user);
		service.delete(1L);
	}

}