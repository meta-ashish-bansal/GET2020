package com.metacube.training.shape;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//Uncomment @Component to make it component.
@Component("mockmailsender")
//@Primary
//@Component
public class MockMailSender implements MailSender {

	@Override
	public void send() {
		System.out.println("Mock mail sent...  :)");

	}

}