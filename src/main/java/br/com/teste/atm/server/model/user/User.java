package br.com.teste.atm.server.model.user;

import br.com.teste.atm.server.model.account.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 *	<p>
 *	Class represents {@link User} entity
 *	</p>
 *
 * @author murata
 * @project atm.server
 */
@Entity
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String password;

	@Transient
	private String confirmPassword;

	@OneToOne
	@JoinColumn(name = "account_id")
	private Account account;

	@ManyToMany
	@JoinTable(name = "customer_role", joinColumns = @JoinColumn(name = "customer_id"))
	private Set<Role> roles;

	/**
	 * Constructor
	 */
	public User(){}

	/**
	 * Constructor with parameters
	 * @param id		id`s User
	 * @param username	username`s User
	 * @param password	password`s User
	 * @param account 	account`s User
	 * @param roles 	role`s Customers
	 */
	public User(final Long id, final String username, final String password, final Account account, final Set<Role> roles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.account = account;
		this.roles = roles;
	}
}
