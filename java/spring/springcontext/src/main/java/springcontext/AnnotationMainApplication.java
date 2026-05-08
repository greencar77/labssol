package springcontext;

import static springcontext.Utils.outputBeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springcontext.conf.SecondConf;

public class AnnotationMainApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SecondConf.class);
		outputBeans(context);
	}
}