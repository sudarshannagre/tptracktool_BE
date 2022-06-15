package com.pgmit.tptt.services;

import org.springframework.context.annotation.Configuration;

import com.pgmit.tptt.model.Mail;

@Configuration
public interface MailServiceIfc {

	String sendMail(Mail mail);
}
