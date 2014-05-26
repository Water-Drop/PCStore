package pcstore.util;

public aspect AspectLogger {
	pointcut LoginAttemptLog(String username, String password):
		(call(int pcstore.ejb.Login.UserLogin(String, String))&&args(username, password));
	
	after(String username, String password) returning : LoginAttemptLog(username, password){
		System.out.println(username);
	}

}
