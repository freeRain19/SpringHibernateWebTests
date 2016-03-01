package entity;

import javax.persistence.*;

/**
 * 
 * @author Tumilovich.D Entity contain User name and password
 */
@Entity
@Table(name = "user")
public class User {
	public User() {
	}

	public User(String accessLevel_idAccessLevel, String name, String password) {
		this.accessLevel_idAccessLevel = accessLevel_idAccessLevel;
		this.name = name;
		this.password = password;
	}

	/**
	 * id User in DB
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUser")
	private int idUser;
	/**
	 * User level may be 1 or 2 (student of tutor)
	 */
	@Column(name = "AccessLevel_idAccessLevel")
	private String accessLevel_idAccessLevel;
	/**
	 * User name
	 */
	@Column(name = "name")
	private String name;
	/**
	 * User password
	 */
	@Column(name = "password")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getAccessLevel_idAccessLevel() {
		return accessLevel_idAccessLevel;
	}

	public void setAccessLevel_idAccessLevel(String accessLevel_idAccessLevel) {
		this.accessLevel_idAccessLevel = accessLevel_idAccessLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User name = " + name + "\tpassword = " + password + "\tidAccessLevel = " + accessLevel_idAccessLevel;
	}
}
