package com.itz.bus.util;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class Email {
	
    private String smtpHost;
    private String smtpPort;
    private String mailer;
    private String from;
    private String subject;
    private String to;
    private String cc;
    private String bcc;
    private String textMessage;
    private Properties props;
    private Session session;
    private MimeMessage message;
    private MimeMultipart multipart;
    private MimeBodyPart messageBodyPart;
    private String contentType;
    
    /**
     * This will construct email object with default values for optional parameters<br><br>
     * <b>connectionTimeout : </b>This will be 3000 milliseconds by default<br>
     * <b>timeout : </b>This will be 3000 milliseconds by default<br>
     * <b>debugMode : </b>This mode will be true by default<br> 
     * @param smtpHost
     * @param smtpPort
     */
    public Email(String smtpHost, String smtpPort) {
    	/*
    	 * DEFAULT VALUES TO SET FOR EMAIL 
    	 */
    	this(smtpHost, smtpPort, "3000", "3000", "true");
    }
    
    /**
     * This will construct email object with extended parameters
     * @param smtpHost sets smtp host for sending an email
     * @param smtpPort sets smtp port for sending an email
     * @param connectionTimeout sets connection timeout, if failed to connection host within mentioned time specified in milliseconds
     * @param timeout sets timeout for sending an email, if failed to send email within mentioned time specified in milliseconds
     * @param debugMode sets debugging mode to <i>true</i> or <i>false</i> for detailed description
     */
    public Email(String smtpHost, String smtpPort, String connectionTimeout, String timeout, String debugMode) {
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
        props = new Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.connectiontimeout", connectionTimeout);
        props.put("mail.smtp.timeout", timeout);
        props.put("mail.debug", debugMode);
        session = Session.getInstance(props, null);
        message = new MimeMessage(session);
        multipart = new MimeMultipart();
        messageBodyPart = new MimeBodyPart();
        from = null;
        subject = null;
        to = null;
        cc = null;
        bcc = null;
        textMessage = null;
        mailer = "";
        contentType = "text/plain";
    }

	/**
	 * @return the smtpHost
	 */
	public String getSmtpHost() {
		return smtpHost;
	}

	/**
	 * @param smtpHost the smtpHost to set
	 */
	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
		props.put("mail.smtp.host", smtpHost);
	}

	/**
	 * @return the smtpPort
	 */
	public String getSmtpPort() {
		return smtpPort;
	}

	/**
	 * @param smtpPort the smtpPort to set
	 */
	public void setSmtpPort(String smtpPort) {
		this.smtpPort = smtpPort;
		props.put("mail.smtp.port", smtpPort);
	}

	/**
	 * @return the mailer
	 */
	public String getMailer() {
		return mailer;
	}

	/**
	 * @param mailer the mailer to set
	 * @throws MessagingException 
	 */
	public void setMailer(String mailer) throws MessagingException {
		this.mailer = mailer;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public void setFrom(String from) throws AddressException, MessagingException {
		this.from = from;
		message.setFrom(new InternetAddress(from));
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 * @throws MessagingException 
	 */
	public void setSubject(String subject) throws MessagingException {
		this.subject = subject;
		message.setSubject(subject);
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public void setTo(String to) throws AddressException, MessagingException {
		this.to = to;
		message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(to, false));
	}

	/**
	 * @return the cc
	 */
	public String getCc() {
		return cc;
	}

	/**
	 * @param cc the cc to set
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public void setCc(String cc) throws AddressException, MessagingException {
		this.cc = cc;
		message.setRecipients(javax.mail.Message.RecipientType.CC, InternetAddress.parse(cc, false));
	}

	/**
	 * @return the bcc
	 */
	public String getBcc() {
		return bcc;
	}

	/**
	 * @param bcc the bcc to set
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public void setBcc(String bcc) throws AddressException, MessagingException {
		this.bcc = bcc;
		message.setRecipients(javax.mail.Message.RecipientType.BCC, InternetAddress.parse(bcc, false));
	}

	/**
	 * @return the textMessage
	 */
	public String getTextMessage() {
		return textMessage;
	}

	/**
	 * @param textMessage the textMessage to set
	 */
	public void setTextMessage(String textMessage) throws MessagingException {
		this.textMessage = textMessage;
        messageBodyPart.setText(textMessage);
		messageBodyPart.setHeader("Content-Type", contentType);
		messageBodyPart.setHeader("X-Mailer", mailer);
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 * @throws MessagingException 
	 */
	public void setContentType(String contentType) throws MessagingException {
		this.contentType = contentType;
	}
    
    /**
     * This method will add the file in message
     * @param filePath
     * @throws MessagingException
     */
    public void addFile(String filePath) throws MessagingException {
    	File file = new File(filePath);
    	addFile(file);
    }
    
    /**
     * This method will add the file in message with specified file name
     * @param file
     * @throws MessagingException
     */
    public void addFile(String filePath, String fileName) throws MessagingException {
    	File file = new File(filePath);
    	addFile(file, fileName);
    }
    
    /**
     * This method will add the file in message with default file name
     * @param file
     * @throws MessagingException
     */
    public void addFile(File file) throws MessagingException  {
   		MimeBodyPart filePart = new MimeBodyPart();
   		FileDataSource fileDataSource = new FileDataSource(file);
   		filePart.setDataHandler(new DataHandler(fileDataSource));
   		filePart.setFileName(fileDataSource.getName());
   		multipart.addBodyPart(filePart);
    }

    /**
     * This method will add the file in message with specified file name
     * @param file
     * @throws MessagingException
     */
    public void addFile(File file, String fileName) throws MessagingException  {
   		MimeBodyPart filePart = new MimeBodyPart();
   		FileDataSource fileDataSource = new FileDataSource(file);
   		filePart.setDataHandler(new DataHandler(fileDataSource));
   		filePart.setFileName(fileName);
   		multipart.addBodyPart(filePart);
    }
    
    /**
     * This method will send the email to the recipients
     * @throws MessagingException
     * @throws IOException
     */
    public void send() throws MessagingException, IOException {
    	
    	messageBodyPart.setText(textMessage);
		messageBodyPart.setHeader("Content-Type", contentType);
		messageBodyPart.setHeader("X-Mailer", mailer);
    	
        multipart.addBodyPart(messageBodyPart);
    	message.setContent(multipart);
    	message.setSentDate(new Date());
		Transport.send(message);
    }
    
    /**
     * This method will send the email to the recipients
     * @throws MessagingException
     * @throws IOException
     */
    public boolean sendMail() {
    	boolean flag = false;
    	try {
			messageBodyPart.setText(textMessage);
			messageBodyPart.setHeader("Content-Type", contentType);
			messageBodyPart.setHeader("X-Mailer", mailer);
	    	multipart.addBodyPart(messageBodyPart);
	    	message.setContent(multipart);
	    	message.setSentDate(new Date());
			Transport.send(message);
			flag = true;
		} catch (SendFailedException e) {
			System.out.println("sendMail Failure:"+to+","+e.getMessage());
			e.printStackTrace();
		}catch (MessagingException e) {
			System.out.println("sendMail Exception:"+to+","+e.getMessage());
			e.printStackTrace();
		}
		return flag;
    }
}