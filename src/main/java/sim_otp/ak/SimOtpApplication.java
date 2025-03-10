package sim_otp.ak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @SpringBootApplication(exclude = {
// 		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
// })
public class SimOtpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimOtpApplication.class, args);
	}

}
