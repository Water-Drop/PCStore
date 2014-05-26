package pcstore.ejb;

public interface Register {
	public int UserRegister(String username, String password);
	public int CheckUsername(String username);
}
