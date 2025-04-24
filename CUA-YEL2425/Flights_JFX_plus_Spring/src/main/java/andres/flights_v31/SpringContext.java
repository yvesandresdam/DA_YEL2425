package andres.flights_v31;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringContext {
    private static final ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    public static <T> T getBean(Class<T> requiredType) {
        return context.getBean(requiredType);
    }
}
