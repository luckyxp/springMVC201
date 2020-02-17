package com.xp.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义的拦截器
 * 主要作用为 当多个handler都要执行相同的步骤时 可以提出来
 */
public class MyInterceptor implements HandlerInterceptor {
    /**
     * 重点,在handler之前执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("判断拦截");
        //登录状态判断
        if (httpServletRequest.getSession().getAttribute("user") != null) {
            System.out.println("已通过");
            return true;
        }
        System.out.println("被拦截");
        httpServletResponse.sendRedirect("/springMVC_07/exception/unknownException");
        return false; //拦截,中断请求,后续的拦截器或handler都不再执行
    }

    /**
     * 在handler之后执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("Post-Handler");
    }

    /**
     * 页面渲染完毕之后执行,基本就是最后一个步骤
     * 一般用来做资源回收
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("After-Completion");
    }
}
