package springcontext;

import static springcontext.Utils.outputBeans;

import org.springframework.context.support.GenericApplicationContext;

import springcontext.domain.Alpha;

public class GenericMainApplication {

	public static void main(String[] args) {
		GenericApplicationContext  context = new GenericApplicationContext();
		context.registerBean(Alpha.class);
		context.refresh();
		outputBeans(context);
	}
}