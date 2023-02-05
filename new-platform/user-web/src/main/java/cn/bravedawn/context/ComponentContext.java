package cn.bravedawn.context;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import java.util.NoSuchElementException;

/**
 * @author : depers
 * @program : new-platform
 * @date : Created in 2023/2/5 22:12
 */
public class ComponentContext {

    /**
     * 组件上下文（Web全局使用）
     */


    public final static String CONTEXT_NAME = ComponentContext.class.getName();

    private static ServletContext servletContext;

    public static ComponentContext getInstance() {
        return (ComponentContext) servletContext.getAttribute(CONTEXT_NAME);
    }


    private Context context;

    public void init(ServletContext servletContext) throws RuntimeException {
        try {
            this.context = (Context) new InitialContext().lookup("java:comp/env");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        servletContext.setAttribute(CONTEXT_NAME, this);
        ComponentContext.servletContext = servletContext;

    }

    public <C> C getComponent(String name) {
        C component = null;
        try {
            component = (C) context.lookup(name);
        } catch (NamingException e) {
            throw new NoSuchElementException(name);
        }

        return component;

    }


    public void destroy() throws RuntimeException {
        if (this.context != null) {
            try {
                context.close();
            } catch (NamingException e) {
                throw new RuntimeException(e);
            }
        }

    }






}
