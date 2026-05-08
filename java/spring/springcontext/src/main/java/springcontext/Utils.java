package springcontext;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;

public class Utils {
    private static final String PACKAGE_PREFIX = "springcontext";

    public static void outputBeans(ApplicationContext context) {
        System.out.println();
        System.out.println("context.getBeanDefinitionNames().length=" + context.getBeanDefinitionNames().length);

        System.out.println("Beans:");
        Arrays.stream(context.getBeanDefinitionNames())
                .filter(bn -> context.getBean(bn).getClass().getCanonicalName().startsWith(PACKAGE_PREFIX))
                .sorted(String::compareTo)
                .forEach(beanName -> System.out.println(context.getBean(beanName).getClass().getCanonicalName() + " - " + beanName));

        System.out.println();
        System.out.println("Beans (other):");
        Arrays.stream(context.getBeanDefinitionNames())
                .filter(bn -> !context.getBean(bn).getClass().getCanonicalName().startsWith(PACKAGE_PREFIX))
                .sorted(String::compareTo)
                .forEach(beanName -> System.out.println(context.getBean(beanName).getClass().getCanonicalName() + " - " + beanName));
    }
}
