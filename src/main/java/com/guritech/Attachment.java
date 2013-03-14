package com.guritech;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.MimeBodyPart;
public class Attachment 
{

	int Multiparts ;
	 String fileAttachment = "D:/Photos/4.jpg";
	 multiparts.addBodyPart(messageBodyPart);
     messageBodyPart  = new MimeBodyPart();
     DataSource sources= new FileDataSource(fileAttachments);  // my file
     messageBodyPart.setDataHandler(new DataHandler(sources));
     messageBodyPart.setFileName(fileAttachments);
     multiparts.addBodyPart(messageBodyPart);
}
	


