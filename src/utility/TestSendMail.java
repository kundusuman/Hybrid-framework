package utility;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * @author Suman Kundu
 * @Purpose Send Mail Using Gmail smtp server
 * @Date 22/8/2018
 * 
 */
public class TestSendMail {
	
    public static String addr;
    //setting the address of the file that need to be send
    TestSendMail(String addr)
    {
    	TestSendMail.addr=addr;
    }
    
	public static String sendMain() 
	{
//creating a property file contains all key and value for gmail smtp server
		Properties p=TestSendMail.loadproperty();
		if(p.getProperty("sendmail").equalsIgnoreCase("yes"))
				{
				String rec=p.getProperty("to");
				String recc[]=rec.trim().split(",");
				Properties props=new Properties();
				props.put("mail.smtp.host","smtp.gmail.com");
				props.put("mail.smtp.auth","true");
				props.put("mail.smtp.starttls.enable","true");
				props.put("mail.smtp.port","587");
		//Starting Session 	
				Session session=Session.getDefaultInstance(props, new javax.mail.Authenticator()
				{
					protected PasswordAuthentication getPasswordAuthentication()
					{
							return new PasswordAuthentication(p.getProperty("email"),p.getProperty("password"));
					}
				}
				);
				try
				{
					//Creating Mime message
						MimeMessage message=new MimeMessage(session);
						InternetAddress add[]=new InternetAddress[recc.length+1];
						//adding your own address to recipient
						add[0]=new InternetAddress(p.getProperty("email"));
						//adding recipients from property file
						for(int i=0;i<recc.length;i++)
									add[i+1]=new InternetAddress(recc[i]);
						message.setFrom(new InternetAddress(p.getProperty("email")));
						message.setSubject( "Autometation Test Report " + p.getProperty("custom_subject"));
						message.setContent( "Below Link is for Automation report\n\n", "text");
						
						 String message1 = "<b>AutoMation Test Report!</b><br>";
					        ;
					        message1 +="<a href='" + addr + "'>" + addr + "</a><br><br></br><br></br>";
					        message1 +="<br><b>Thanks and regards!</b></br>";
					        message1 +="<font color=red>    "+ p.getProperty("sendername") +"</font>";
					
		
						message.setRecipients(Message.RecipientType.TO, add);
						
				        MimeBodyPart messageBodyPart = new MimeBodyPart();
				        Multipart multipart = new MimeMultipart();
				        
				        messageBodyPart = new MimeBodyPart();
				        messageBodyPart.setText("PFA for my Automation Report");
				        String file = addr;
				        //adding file in datasource
				        String fileName = "MY_TEST_REPORT.html";
				        DataSource source = new FileDataSource(file);
				        messageBodyPart.setDataHandler(new DataHandler(source));
				        messageBodyPart.setFileName(fileName);
				        multipart.addBodyPart(messageBodyPart);
				        
				        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
				        messageBodyPart1.setContent(message1, "text/html");
				        multipart.addBodyPart(messageBodyPart1);
				        message.setContent( multipart);
				        
				        Log4j.debug("trying to sending message");
						Transport.send(message);
						return "success";
				
				}
				catch(Exception e)
				{
					e.printStackTrace();
					Log4j.error("message sending fail");
					return "failure";
				}
			}
		else
			return "failure";
	}
	//loading property file
	private static Properties loadproperty() 
	{
		FileReader reader=null;
		Properties p=null;
		try {
			reader = new FileReader("./CustomizeThings.properties");
			p=new Properties();  
			p.load(reader);
		} catch (FileNotFoundException e) {
			Log4j.error("property file load fail  | message send fail");
		} catch (IOException e) {
			Log4j.error("property file load fail  | message send fail");
		} 
	    return p;
	}
	}