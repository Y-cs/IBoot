package self.ibean.boot.test;

import org.springframework.context.annotation.ComponentScan;
import self.iboot.context.ApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author Y-cs
 * @date 2021/5/25 15:25
 */
@ComponentScan("self.ibean.boot.test.controller")
public class Application {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext.run(Application.class,args);

        System.out.println("容器已启动");
    }


}
