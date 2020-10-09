package com.vastika.uis.util;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class EmailUtil {
	
	public static final String FROM_EMAIL="santosh@gmail.com";

	public static void sendEmail(MailSender mailSender, String toEmail, String subject, String messageBody) {
		SimpleMailMessage mailMessage= new SimpleMailMessage();
		mailMessage.setFrom(FROM_EMAIL);
		mailMessage.setSubject(subject);
		mailMessage.setText(messageBody);
		mailMessage.setTo(toEmail);
		mailSender.send(mailMessage);
	}
}
