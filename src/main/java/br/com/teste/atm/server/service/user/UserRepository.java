package br.com.teste.atm.server.service.user;

import br.com.teste.atm.server.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Repository for User
 * </p>
 *
 *
 * @author murata
 * @project atm.server
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(final String username);
	User findUserById(final Long id);

}