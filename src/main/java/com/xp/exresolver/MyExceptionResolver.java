package com.xp.exresolver;

import com.xp.exception.LoginException;
import com.xp.exception.PermissionException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 自定义异常解析器 需实现HandlerExceptionResolver
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    /**
     * 将在handler中抛出异常时执行
     * 将捕获任何一个handler中的任何一个异常
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return 返回一个ModelAndView 作用是 跳转到错误视图
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        e.printStackTrace(); //打印异常栈信息,开发时用,上线删除
        //识别异常 从而跳转到不同的错误界面
        if (e instanceof LoginException) {
            modelAndView.setViewName("redirect:/exception/loginException");
        }else if(e instanceof PermissionException){
            modelAndView.setViewName("redirect:/exception/permissionException");
        } else{
            modelAndView.setViewName("redirect:/exception/unknownException");
        }
        return modelAndView;
    }
}
