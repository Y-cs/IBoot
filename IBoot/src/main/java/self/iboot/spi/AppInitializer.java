package self.iboot.spi;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author Y-cs
 * @date 2021/5/25 19:35
 */
public interface AppInitializer {


    public void onStartup(ServletContext servletContext) throws ServletException;

}
