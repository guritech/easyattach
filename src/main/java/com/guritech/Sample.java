package com.guritech;
//import java.util.*;
import javax.activation.DataHandler;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
//port javax.activation.*;
import java.util.Properties;




public class Sample {
	
	static long startTime = System.currentTimeMillis();
	

  	/**
	 * @param args
	 */
	    private static final String host = "smtp.mail.yahoo.com";
	    private static final int port = 587;//465,587,25
	    private static final String from = "gurinder_inder@yahoo.com";
	    private static final String pwd  = "ricky22525";
	    private static final String to = "gurinder22525@gmail.com";
	 
        /**
         * @param args
         * @throws Exception
         */
        public static void main(String[] args) throws Exception
	    {
	        Properties props = System.getProperties();
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host)   ;
	        props.put("mail.smtp.user", from)   ;
	        props.put("mail.smtp.password", pwd);
	        props.put("mail.smtp.port", port)   ;
	        props.put("mail.smtp.auth", "true") ;
	        Session session = Session.getDefaultInstance(props);
	        MimeMessage message = new MimeMessage(session);

	        // Set From: header field of the header.
	        message.setFrom(new InternetAddress(from));

	        // Set To: header field of the header.
	        message.addRecipient(Message.RecipientType.TO,
	        new InternetAddress(to));

	        // Set Subject: header field
	        message.setSubject("message countdown ");

	        // Now set the actual message
	        
	        message.setText("This is actual message");

	        // Send message
	        Transport transport = session.getTransport("smtp");
	        
	        // attach your file
	        // create the message part 
	        MimeBodyPart messageBodyPart = 
	          new MimeBodyPart();

	        //fill message
	        messageBodyPart.setText("try karda ");

	        String fileAttachment = "D:/Photos/4.jpg";
	        
	        // first file attach 	        
	        Multipart multipart = new MimeMultipart();
	        multipart.addBodyPart(messageBodyPart);
	        messageBodyPart  = new MimeBodyPart();
	        DataSource source= new FileDataSource(fileAttachment);// my file
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(fileAttachment);
	        multipart.addBodyPart(messageBodyPart);
	        
	        
	        // 2ns file attach 
	            
	        String fileAttachments = "D:/Photos/5.jpg";
	        Multipart multiparts = new MimeMultipart();
	        multiparts.addBodyPart(messageBodyPart);
	        messageBodyPart  = new MimeBodyPart();
	        DataSource sources= new FileDataSource(fileAttachments);  // my file
	        messageBodyPart.setDataHandler(new DataHandler(sources));
	        messageBodyPart.setFileName(fileAttachments);
	        multiparts.addBodyPart(messageBodyPart);
	        	
	        // Put parts in message
	       
	        message.setContent(multipart);
	        message.setContent(multiparts);// 2nd file
	        
	        //  SmtpServer.Timeout = 999999999;//provessingbar
	        
	        transport.connect(host, from, pwd);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	       // System.out.println(" message Sent successfully....");           
	        
	        long endTime   = System.currentTimeMillis();
	        long totalTime = endTime - startTime;
	        	
	        float   Time ;
	        Time=totalTime/60000; // to convert millisec  to sec  //158201 milisec
	        	      
	        	        
	        System.out.println("message send sucessfuly in " +" " + Time +" "+ "Minute" );
	       
	       
	        for(int i=0;i<11;i++) 
			{

				System.out.println(i);
					try
				{
					Thread.sleep(1000);
				 
				}
					catch (InterruptedException e) 
				  
				{
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				 
				}
	        
	       	        
			 }
	   }
		 
}


