package proje;
/**
 * A class for all people's same features
 * (all people have name ,surname,id,mail and password)
 */
public abstract class PersonalClass {
	private static int idHolder=1000;
	private int id;
	private String name;
	private String surname;
	private String mail;
	private String password;
	/**
	 * constructor
	 */
	public PersonalClass() {
		this.setId(-1);
		this.setName(null);
		this.setSurname(null);
		idHolder++;
	}
	/**
	 * gets id
	 * @return			returns id
	 */
	public int getId() {
		return id;
	}
	/**
	 * gets id
	 * @param id		id for set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * gets id
	 * @return			returns name
	 */
	public String getName() {
		return name;
	}
	/**
	 * gets id
	 * @param name		name for set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * gets id
	 * @return			returns surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * gets id
	 * @param surname	surname for set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * gets id
	 * @return			returns password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * gets id
	 * @param password	password for set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * gets id
	 * @return			returns mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * gets id
	 * @param	mail	mail for set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
