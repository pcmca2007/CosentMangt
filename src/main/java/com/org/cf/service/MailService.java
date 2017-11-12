package com.org.cf.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;



@Service("mailService")
public class MailService {
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private SimpleMailMessage alertMailMessage;


	public SimpleMailMessage getAlertMailMessage() {
		return alertMailMessage;
	}

	public void setAlertMailMessage(SimpleMailMessage alertMailMessage) {
		this.alertMailMessage = alertMailMessage;
	}

	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	
	public void sendMail(String from, String to, String subject, String body) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		System.setProperty("java.net.preferIPv4Stack" , "true");	
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		System.out.println("Before Sending Mail");
		mailSender.send(message);
		
		//return true;
		
	}
	
	public void sendAlertMail(String alert) {
		
		SimpleMailMessage mailMessage = new SimpleMailMessage(alertMailMessage);
		
		mailMessage.setText(alert);
		mailSender.send(mailMessage);
	}

	


}
