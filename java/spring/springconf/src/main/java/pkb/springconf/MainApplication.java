package pkb.springconf;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);
		outputBeans(context);
	}

	private static void outputBeans(ConfigurableApplicationContext context) {
		System.out.println();
		System.out.println("Beans:");
		Arrays.asList(context.getBeanDefinitionNames())
				.stream()
				.filter(bn -> context.getBean(bn).getClass().getCanonicalName().startsWith("pkb."))
				.sorted(String::compareTo)
				.forEach(beanName -> {
					System.out.println(context.getBean(beanName).getClass().getCanonicalName() + " - " + beanName);
				});
		System.out.println();
	}
}