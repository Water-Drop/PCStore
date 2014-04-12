package pcstore.ejb;

import javax.ejb.Stateless;


@Stateless
public class LoginBean implements Login{
	public int UserLogin(String username, String password){
		int id = 0;
		if (username != null && password != null){
			String user = "test";
			String pass = "dc9bdb52d04dc20036dbd8313ed055";
			if (username.equals(user) && password.equals(pass)){
				id = 1;
			}
		}
		return id;
	}
}
