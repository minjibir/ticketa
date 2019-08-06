package ng.ticketa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class})
public class TicketaApplication
{
//	CommandLineRunner
	public static void main(String[] args)
	{
		SpringApplication.run(TicketaApplication.class, args);
	}
}
