package cn.bravedawn.user.context;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import java.rmi.Naming;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 组件上下文（web 应用全局使用）
 * @author : depers
 * @program : mall
 * @description:
 * @date : Created in 2021/12/5 12:13
 */
public class ComponentContext {

    public static final String CONTEXT_NAME = ComponentContext.class.getName();

    private Context context;

    private static ServletContext servletContext;

    public static ComponentContext getInstance() {
        return (ComponentContext) servletContext.getAttribute(CONTEXT_NAME);
    }

    public void init(ServletContext servletContext) {
        try {
            this.context = (Context) new InitialContext().lookup("java:comp/env");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        servletContext.setAttribute(CONTEXT_NAME, this);
        ComponentContext.servletContext = servletContext;
    }



    /**
     * 通过名称进行依赖查找
     * @param jndiName
     * @param <T>
     * @return
     */
    public <T> T getComponent(String jndiName) {
        T component = null;
        try {
            component = (T) this.context.lookup(jndiName);
        } catch (NamingException e) {
            throw new NoSuchElementException(jndiName);
        }
        return component;
    }


    public void destroy() {
        if (this.context != null) {
            try {
                this.context.close();
            } catch (NamingException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
