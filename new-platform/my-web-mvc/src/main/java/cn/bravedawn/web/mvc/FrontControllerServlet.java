package cn.bravedawn.web.mvc;

import cn.bravedawn.web.mvc.controller.Controller;
import cn.bravedawn.web.mvc.controller.PageController;
import cn.bravedawn.web.mvc.controller.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.Path;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author : depers
 * @program : new-platform
 * @description:
 * @date : Created in 2022/11/23 11:36
 */
public class FrontControllerServlet extends HttpServlet {


    private Map<String, Controller> controllerMapping = new HashMap<>();

    private Map<String, HandlerMethodInfo> handleMethodInfoMapping = new HashMap<>();


    public void init() {
        initHandleMethod();
    }

    /**
     * 读取所有的 RestController 的注解元信息 @Path 利用 ServiceLoader 技术（Java SPI）
     */
    private void initHandleMethod() {
        for (Controller controller : ServiceLoader.load(Controller.class)) {
            Class<?> controllerClass = controller.getClass();
            Path pathFromClass = controllerClass.getAnnotation(Path.class);
            String requestPath = pathFromClass.value();
            requestPath = requestPath.startsWith("/") ? requestPath : "/" + requestPath;
            Method[] publicMethods = controllerClass.getMethods();

            // 处理方法支持的Http方法集合
            for (Method method : publicMethods) {
                Set<String> supportedHttpMethods = findSupportedHttpMethods(method);
                Path pathFromMethod = method.getAnnotation(Path.class);
                if (pathFromMethod != null) {
                    String methodRequestPath = pathFromMethod.value();
                    methodRequestPath = methodRequestPath.startsWith("/") ? methodRequestPath : "/" + methodRequestPath;
                    requestPath = requestPath + methodRequestPath;
                    handleMethodInfoMapping.put(requestPath, new HandlerMethodInfo(requestPath, method, supportedHttpMethods));
                }

            }
            controllerMapping.put(requestPath, controller);
        }
    }


    /**
     * 获取处理方法中标注的 HTTP方法集合
     * @param method 处理方法
     * @return
     */
    private Set<String> findSupportedHttpMethods(Method method) {
        Set<String> supportedHttpMethods = new LinkedHashSet<>();
        for (Annotation annotationFromMethod : method.getAnnotations()) {
            HttpMethod httpMethod = annotationFromMethod.annotationType().getAnnotation(HttpMethod.class);
            if (httpMethod != null) {
                supportedHttpMethods.add(httpMethod.value());
            }
        }

        if (supportedHttpMethods.isEmpty()) {
            supportedHttpMethods.addAll(Arrays.asList(HttpMethod.GET, HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE,
                    HttpMethod.HEAD, HttpMethod.OPTIONS));
        }

        return supportedHttpMethods;
    }


    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        System.out.println("requestURI-----------------------" + requestURI);

        String servletContextPath = request.getContextPath();
        String prefixPath = servletContextPath;

        String requestMappingPath = StringUtils.substringAfter(requestURI, StringUtils.replace(prefixPath, "//", "/"));

        Controller controller = controllerMapping.get(requestMappingPath);

        if (controller != null) {
            HandlerMethodInfo handlerMethodInfo = handleMethodInfoMapping.get(requestMappingPath);
            try{
                if (handlerMethodInfo != null) {
                    String httpMethod = request.getMethod();
                    if (!handlerMethodInfo.getSupportedHttpMethods().contains(httpMethod)) {
                        // HTTP方法不支持
                        response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
                        return;
                    }
                }

                if (controller instanceof PageController) {
                    PageController pageController = PageController.class.cast(controller);
                    String viewPath = pageController.execute(request, response);

                    ServletContext servletContext = request.getServletContext();
                    if (!viewPath.startsWith("/")) {
                        viewPath = "/" + viewPath;
                    }
                    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(viewPath);
                    requestDispatcher.forward(request, response);
                    return;
                } else if (controller instanceof RestController) {

                    Object result = handlerMethodInfo.getHandlerMethod().invoke(controller, request, response);
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = response.getWriter();
                    ObjectMapper objectMapper = new ObjectMapper();
                    writer.write(objectMapper.writeValueAsString(result));
                    writer.close();
                }

            } catch(Throwable throwable) {
                throwable.printStackTrace();
                if (throwable.getCause() instanceof IOException) {
                    throw (IOException) throwable.getCause();
                } else {
                    throw new ServletException(throwable.getCause());
                }
            }
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
    }



}
