package br.com.teste.atm.server.model.account;

import br.com.teste.atm.server.model.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * <p>
 * Class represents an {@link Account} entity
 * </p>
 *
 * @author murata
 * @project atm.server
 */
@Entity
@Getter
@Setter
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private Double balance;

	@OneToOne
	private User user;

	/**
	 * Constructor
	 */
	public Account(){}

	/**
	 * Constructor with parameters
	 * @param id		id`s Account
	 * @param balance	balance`s Account
	 * @param user		user`s Account
	 */
	public Account(final Long id, final Double balance, final User user) {
		this.id = id;
		this.balance = balance;
		this.user = user;
	}
}
