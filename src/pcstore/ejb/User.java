package pcstore.ejb;

public class User {
	private String Name;
	private int Id;
	private String Password;
	public String getName() {
		return Name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public User(String name, int id, String password) {
		super();
		Name = name;
		Id = id;
		Password = password;
	}
	
}
