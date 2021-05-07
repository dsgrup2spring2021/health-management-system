package proje;

public abstract class PersonalClass {
	private static int idHolder=1000;
	private int id;
	private String name;
	private String surname;
	private String mail;
	private String password;
	public PersonalClass() {
		this.setId(-1);
		this.setName(null);
		this.setSurname(null);
		idHolder++;
	}
	public PersonalClass(String name,String surname) {
		this.setId(idHolder);
		this.setName(name);
		this.setSurname(surname);
		idHolder++;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
