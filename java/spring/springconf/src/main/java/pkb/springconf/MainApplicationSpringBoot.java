package pkb.springconf;

import static pkb.springconf.Utils.outputBeans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplicationSpringBoot {

	public static void main(String[] args) {
		final ConfigurableApplicationContext context = SpringApplication.run(MainApplicationSpringBoot.class, args);
		outputBeans(context);
	}
}