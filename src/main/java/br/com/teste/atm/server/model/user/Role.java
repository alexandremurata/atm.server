package br.com.teste.atm.server.model.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 *	<p>
 *	Class represents {@link Role} entity
 *	</p>
 *
 * @author murata
 * @project atm.server
 */
@Entity
@Getter
@Setter
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	/**
	 * Constructor
	 */
	public Role(){}

	/**
	 * Constructor with parameters
	 * @param id	id's role
	 * @param name	name's role
	 */
	public Role(final Long id, final String name) {
		this.id = id;
		this.name = name;
	}
}
