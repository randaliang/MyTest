
package com.superhope.mvcconfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 日志拦截器,记录访问时间、用户userId
 * @author hui
 *
 */
public class LogHandlerInterceptor  extends HandlerInterceptorAdapter{
    private final Logger logger = LoggerFactory.getLogger(LogHandlerInterceptor.class);
    private final static String USER_KEY = "userId";

    private NamedThreadLocal<Long>  startTimeThreadLocal =   
        new NamedThreadLocal<Long>("StopWatch-StartTime"); 
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     * 只有返回true才会继续向下执行，返回false取消当前请求
     */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
//		Session session = SessionUtil.getSession();
//		if(session!=null){
//			//日志记录userId
//	        MDC.put(USER_KEY, session.getUserId());
//		}
//	    long beginTime = System.currentTimeMillis();//1、开始时间 
//	    startTimeThreadLocal.set(beginTime);//线程绑定变量（该数据只有当前请求的线程可见）  
//	    logger.info("开始执行{}:{}",request.getRequestURI(),request.getMethod());
		return true;
	}
	/**
	 * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	    long endTime = System.currentTimeMillis();//2、结束时间  
        long beginTime = startTimeThreadLocal.get();//得到线程绑定的局部变量（开始时间）  
        long consumeTime = endTime - beginTime;//3、消耗的时间  
	    logger.info("执行结束请求：{}所用时间：{}",request.getRequestURI(),consumeTime);
	}
	/**
	 * 在整个请求结束之后被调用，渲染了对应的视图之后执行（主要是用于进行资源清理工作）
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
        MDC.remove(USER_KEY);
        startTimeThreadLocal.remove();
	}
	
}
