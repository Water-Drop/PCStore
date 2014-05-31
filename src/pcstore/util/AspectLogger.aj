package pcstore.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public aspect AspectLogger {
	pointcut LoginAttemptLog(String username, String password):
		(call(int pcstore.ejb.Login.UserLogin(String, String))&&args(username, password));
	
	after(String username, String password) returning : LoginAttemptLog(username, password){
		System.out.println(username);
		File f = new File("log.txt");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		FileWriter fw;
		try {
			fw = new FileWriter(f, true);
			fw.write(username + " ");
			fw.write(df.format(new Date()) + "\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
