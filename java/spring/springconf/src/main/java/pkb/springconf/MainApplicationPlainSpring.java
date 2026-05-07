package pkb.springconf;

import static pkb.springconf.Utils.outputBeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pkb.springconf.conf.SecondConf;

public class MainApplicationPlainSpring {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SecondConf.class);
		outputBeans(context);
	}
}