/**
 * 文件名称: MDCInterceptor.java 系统名称: 民生银行移动办公 模块名称: TODO:(用一句话描述该属于哪个模块) 功能说明:
 * TODO:(用一句话描述该文件做什么) 系统版本: 开发人员: dongliang.liu 开发时间: 2017年11月23日 下午5:53:23
 * 相关文档: 修改记录: 修改日期 修改人员 修改说明
 */
package com.util.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO: 添加类/接口功能描述
 * 
 * @author dongliang.liu
 * @date 2017年11月23日
 */
public class MDCInterceptor implements HandlerInterceptor {

	private final Logger logger = LoggerFactory.getLogger(MDCInterceptor.class);

	/**
	 * TODO: 添加override说明
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, Object)
	 **/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		// controller调用前执行
		MDC.put("deviceID", "设备ID，从报文中获取");
		MDC.put("userID", "用户ID，登录后从session中获取");
		MDC.put("sessionID", "会话ID，从session中获取");
		MDC.put("bizSN", "交易流水号，从报文中获取");
		MDC.put("bizID", "交易ID，从报文中获取");
		return true;// 只有返回true才会继续向下执行，返回false取消当前请求
	}

	/**
	 * TODO: 添加override说明
	 *
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, Object,
	 *      org.springframework.web.servlet.ModelAndView)
	 **/
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		// 视图被渲染之前，controller调用之后执行
	}

	/**
	 * TODO: 添加override说明
	 *
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, Object,
	 *      Exception)
	 **/
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		// TODO Auto-generated method stub
		// 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行,主要用于资源清理。
	}

}
