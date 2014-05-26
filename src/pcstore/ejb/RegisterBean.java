package pcstore.ejb;

import javax.ejb.Stateless;

@Stateless
public class RegisterBean implements Register{
	public int UserRegister(String username, String password){
		int userid = 0;
		return userid;
	};
	public int CheckUsername(String username){
		int isValid = 0;
		if (username.contains(" ")){
			return -1;//include whitespace
		}
		else if (username.contains("<") || username.contains(">") || username.contains("\\")){
			return -2;//include illegal character
		}
		else {
			return isValid;
		}
	};
}
