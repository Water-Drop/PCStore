package pcstore.ejb;

import javax.ejb.Remote;

@Remote
public interface Login {
	public int UserLogin(String username, String password);
}


