import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sarrz.lan.model.Role;
import ru.sarrz.lan.model.User;
import ru.sarrz.lan.web.AbstractUserController;

import java.time.LocalDate;
import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml","spring/spring-db.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            AbstractUserController adminUserController = appCtx.getBean(AbstractUserController.class);
            adminUserController.create(new User(100000,"firstName", "lastName","em@ya.ru","1234444", Role.ROLE_USER));
            System.out.println();

        }
    }
}
