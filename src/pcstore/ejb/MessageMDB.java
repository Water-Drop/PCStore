package pcstore.ejb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

	 @MessageDriven(name = "MessageMDBSample", activationConfig = {
	 @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
	 @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/order"),
	 @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })

	public class MessageMDB implements MessageListener {

	   public void onMessage(Message message) {

	     TextMessage tm = (TextMessage) message;
	       try {
	    	   String drive = "com.mysql.jdbc.Driver";
	    	   String url = "jdbc:mysql://127.0.0.1:3306/PCStore";
	    	   Connection conn = null;
				 try {
					Class.forName(drive);
				    conn = DriverManager.getConnection(url, "root", "asdfg123");   
				    try{
				    conn.setAutoCommit(false);
				    PreparedStatement ps1 = conn.prepareStatement("UPDATE item SET Stock=Stock-1 WHERE Name=?");
				    ps1.setString(1, tm.toString());
				    PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM orderdetai");
				    ResultSet rs = ps2.executeQuery();
				    rs.last();
				    int count = rs.getRow();  
				    PreparedStatement ps3 = conn.prepareStatement("INSERT INTO orderdetail VALUES (?, ?)");
				    count ++;
				    ps3.setInt(1, count);
		            ps3.setString(2, tm.toString());
		            ps3.execute();
		            conn.commit();
		            }catch(Exception e){
				    	conn.rollback();
				    	e.printStackTrace();
				    }
		           } catch (ClassNotFoundException e) {
				    System.out.println(e.getMessage());
				   } catch (SQLException e) {
				    System.out.println(e.getMessage());
				   }
	         System.out.println("Received message "+tm.getText());
	       } catch (JMSException e) {
	  
	        e.printStackTrace();
	       }
	 

	   }

	}

