package springcontext;

import static springcontext.Utils.outputBeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springcontext.conf.SecondConf;

public class ClassPathXmlMainApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		outputBeans(context);
	}
}