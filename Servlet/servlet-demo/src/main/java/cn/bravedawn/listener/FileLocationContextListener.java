package cn.bravedawn.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;

/**
 * @author : depers
 * @program : servlet-demo
 * @date : Created in 2022/7/5 9:12
 */

@WebListener
public class FileLocationContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // rootPath指的就是本地Tomcat的地址：D:\program_file\apache-tomcat-8.5.37
        String rootPath = System.getProperty("catalina.home");
        ServletContext ctx = sce.getServletContext();
        String relativePath = ctx.getInitParameter("tempfile.dir");
        File file = new File(rootPath + File.separator + relativePath);
        if(!file.exists()) {
            file.mkdirs();
            ctx.log("File Path = " + file.getPath());
        }
        System.out.println("File Directory created to be used for storing files");
        ctx.setAttribute("FILES_DIR_FILE", file);
        ctx.setAttribute("FILES_DIR", rootPath + File.separator + relativePath);
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
