package cn.bravedawn.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @author : depers
 * @program : servlet-demo
 * @description: 声明周期方法
 * @date : Created in 2021/11/20 17:51
 */
public class LifeCycle extends HttpServlet {


    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
