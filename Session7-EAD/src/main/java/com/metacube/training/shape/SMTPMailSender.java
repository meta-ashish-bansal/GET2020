package com.metacube.training.shape;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//Uncomment @Component to make it component.
@Component("smtpmailsender")
//@Primary
//@Component
public class SMTPMailSender implements MailSender {

	@Override
	public void send() {
		System.out.println("SMTP Mail sent...  :)");

	}

}