package com.pfa.pack.util.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtilImpl implements EmailUtil {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendEmail(final String to, final String subject, final String body) {
		
		final MimeMessage message = javaMailSender.createMimeMessage();
		final MimeMessageHelper helper = new MimeMessageHelper(message);
		
		try {
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body);
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}
		finally {
			try {
				javaMailSender.send(message);
			}
			catch (MailAuthenticationException e) {
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
		}
		
	}
	
	
	
}




