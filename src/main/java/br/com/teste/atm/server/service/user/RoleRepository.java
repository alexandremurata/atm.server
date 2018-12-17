package br.com.teste.atm.server.service.user;

import br.com.teste.atm.server.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author murata
 * @project atm.server
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
