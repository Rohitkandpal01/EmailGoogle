package com.email.EmailGoogle;

import com.email.EmailGoogle.GoogleMail.SendEmail;
import com.email.EmailGoogle.GoogleMail.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Calendar;

@SpringBootApplication
@EnableScheduling
public class EmailGoogleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailGoogleApplication.class, args);
	}


	@Autowired
	SendEmail sendEmail;
	
	@Scheduled(cron = "0 0 11-18 ? 2-6 ?")
//	@Scheduled(fixedRate = 5000)
	public void run() throws Exception {
		User user = new User();
		user.setTo("shobhit.gupta@qainfotech.com");
		user.setFrom("qainfotechq@guser.com");
		user.setSubject("Testing user");
		user.setContent("Hii Shobhit, /n Task completed");

		String s = sendEmail.send(user);
		System.out.println(s);
		System.out.println("Current time is :: " + Calendar.getInstance().getTime());
	}

}
