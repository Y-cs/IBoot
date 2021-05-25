package self.iboot.context.impl;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import self.iboot.context.ContainersContext;

import javax.servlet.ServletException;

/**
 * @author Y-cs
 * @date 2021/5/25 13:55
 */
public class TomcatContainersContext implements ContainersContext {

    private int port = 8080;
    public static final String DEFAULT_PROTOCOL = "org.apache.coyote.http11.Http11NioProtocol";
    private String protocol = DEFAULT_PROTOCOL;

    public TomcatContainersContext(int port) {
        this.port = port;
    }


    @Override
    public void startWebContextService() throws LifecycleException {
        new Thread(() -> {

            Tomcat tomcat = new Tomcat();
            //设置端口
            tomcat.setPort(port);
            //2.构建Connector对象(连接器),负责协议配置,端口配置等
//            Connector conn=new Connector(protocol);
//            tomcat.getService().addConnector(conn);

            tomcat.setBaseDir(this.getClass().getClassLoader().getResource("").getPath() + "webapp");

            try {
                tomcat.addWebapp("/", "d:\\");
                tomcat.start();
            } catch (LifecycleException | ServletException e) {
                e.printStackTrace();
            }

            System.out.println("tomcat is start port: " + port);
            tomcat.getServer().await();
        }).start();
    }


}
