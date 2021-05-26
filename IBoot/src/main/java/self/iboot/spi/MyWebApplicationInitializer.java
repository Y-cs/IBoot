package self.iboot.spi;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;
import self.iboot.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author Y-cs
 * @date 2021/5/25 15:52
 */
public class MyWebApplicationInitializer implements AppInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(ApplicationContext.getWebApplicationContext());
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/*");

        System.out.println("web application onStartup is run");
    }


}
