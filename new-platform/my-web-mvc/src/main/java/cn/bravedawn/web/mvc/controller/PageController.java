package cn.bravedawn.web.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 页面控制器，负责服务端页面渲染
 *
 * @author : depers
 * @program : new-platform
 * @description:
 * @date : Created in 2022/11/24 21:38
 */
public interface PageController extends Controller {

    /**
     * @param request HTTP请求
     * @param response HTTP响应
     * @return 视图地址路径
     * @throws Throwable 异常
     */
    String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable;
}
