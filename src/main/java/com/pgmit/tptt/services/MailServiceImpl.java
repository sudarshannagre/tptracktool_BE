package com.pgmit.tptt.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.pgmit.tptt.constant.APIConstant;
import com.pgmit.tptt.model.Mail;

@Service
public class MailServiceImpl implements MailServiceIfc{

	@Autowired
    JavaMailSender mailSender;
	
	@Override
	public String sendMail(Mail mail) {

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		 
        try {
 
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
 
            mimeMessageHelper.setSubject(mail.getSubject());
            mimeMessageHelper.setFrom(mail.getFrom());
            mimeMessageHelper.setTo(mail.getTo());
            mimeMessageHelper.setText(mail.getBody());
 
            mailSender.send(mimeMessageHelper.getMimeMessage());
 
        } catch (MessagingException e) {
            e.printStackTrace();
            return APIConstant.MAIL_SEND_FAIL;
        }
		return APIConstant.MAIL_SEND_SUCCESS;
	}

}
