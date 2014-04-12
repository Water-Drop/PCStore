package pcstore.util;

import java.security.*;

public class MD5Tool {
	 public MD5Tool() {
	    }
	public String MD5Encrypt(String inStr) {  
	    MessageDigest md = null;  
	    String outStr = null;  
	    try {   
		     md = MessageDigest.getInstance("MD5");       
		     byte[] digest = md.digest(inStr.getBytes());       	 
		     outStr = bytetoString(digest);  
	    } 
	    catch (NoSuchAlgorithmException nsae) {   
	    	nsae.printStackTrace();  
	    }  
	    return outStr; 
	} 

	public String bytetoString(byte[] digest) {  
	    String str = "";  
	    String tempStr = "";  
	    for (int i = 1; i < digest.length; i++) {   
	    	tempStr = (Integer.toHexString(digest[i] & 0xff));   
	    	if (tempStr.length() == 1) {    
	    		str = str + "0" + tempStr;   
	    	} 
	     else {    
	    	 str = str + tempStr;   
	     	}  
	    }  
	    return str.toLowerCase(); 
	}
}
