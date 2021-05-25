package self.iboot.context;

import org.apache.catalina.LifecycleException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import self.iboot.context.impl.TomcatContainersContext;

/**
 * @author Y-cs
 * @date 2021/5/25 16:28
 */
public class ApplicationContext {

    private static WebApplicationContext webApplicationContext;

    public static <T> void run(Class<T> clazz, String[] args) {
        try {
            // Load Spring web application configuration
            //通过注解的方式初始化Spring的上下文
            AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
            webApplicationContext = ac;

            //注册spring的配置类（替代传统项目中xml的configuration）
            ac.register(clazz);
            ac.refresh();

            ContainersContext webContext = new TomcatContainersContext(8080);
            webContext.startWebContextService();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }


    public static WebApplicationContext getWebApplicationContext() {
        return webApplicationContext;
    }
}
