package hedin.stuff.progg.dao;

public class User {

	String id;
	/**
	 * 
	 */
	String usernameg;
	/**
	 * Not Salted yet
	 */
	String password;
	
	String organizationId;
	

	public User(String id, String usernameg, String password,
			String organizationId) {
		super();
		this.id = id;
		this.usernameg = usernameg;
		this.password = password;
		this.organizationId = organizationId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsernameg() {
		return usernameg;
	}

	public void setUsernameg(String usernameg) {
		this.usernameg = usernameg;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	
	
	
}
