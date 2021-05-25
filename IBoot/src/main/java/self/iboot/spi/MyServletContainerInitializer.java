package self.iboot.spi;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * @author Y-cs
 * @date 2021/5/25 15:51
 */
@HandlesTypes(AppInitializer.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {


    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        try {
            if (set==null||set.isEmpty()) {
                return;
            }
            for (Class<?> clazz : set) {
                if (AppInitializer.class.isAssignableFrom(clazz)) {
                    AppInitializer webApplicationInitializer = (AppInitializer)clazz.newInstance();
                    webApplicationInitializer.onStartup(servletContext);
                }
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("servlet onStartup is run");
    }


}
