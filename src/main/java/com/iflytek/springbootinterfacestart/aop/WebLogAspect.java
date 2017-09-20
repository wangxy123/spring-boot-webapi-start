package com.iflytek.springbootinterfacestart.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.iflytek.springbootinterfacestart.common.ResultCode;
import com.iflytek.springbootinterfacestart.exception.ParaIllegalException;
import com.iflytek.springbootinterfacestart.model.Result;
import com.iflytek.springbootinterfacestart.model.entity.Operation;
import com.iflytek.springbootinterfacestart.model.entity.WebLog;

import static com.iflytek.springbootinterfacestart.common.util.WebLogUtil.*;

/**
 * @ClassName: WebLogAspect
 * @Description: 所有外部请求统一日志记录
 * @author xywang
 * @date 2017年6月29日 下午4:26:35
 * 
 */
@Aspect
@Component
@Order(-5)
public class WebLogAspect {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(WebLogAspect.class);

	@Pointcut("execution(public com.iflytek.springbootinterfacestart.model.Result *(..))")
	public void webLog() {
	}

	@Around("webLog()")
	public Object process(ProceedingJoinPoint point) throws Throwable {

		WebLog webLog = getLog();

		webLog.getOperates().add(new Operation("WebLogAspect.process.in"));
		Long start = System.currentTimeMillis();
		Result<?> returnValue = null;

		// 访问目标方法的参数：
		Object[] args = point.getArgs();
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = (HttpServletRequest) attributes
				.getRequest();

		webLog.setUrl(request.getRequestURL().toString());
		webLog.setIp(getIpAddress(request));
		webLog.setHttp_method(request.getMethod());
		webLog.setClass_method(point.getSignature().getDeclaringTypeName()
				+ "." + point.getSignature().getName());
		if (args.length > 0)
			webLog.setWebargs(JSON.toJSONString(args[0]));
		else {
			webLog.setWebargs("空");
		}

		try {
			returnValue = (Result<?>) point.proceed(args);
			webLog.setRet(JSON.toJSONString(returnValue));
		} catch (Throwable e) {
			returnValue = handlerException(point, e);
		}

		webLog.setTime(System.currentTimeMillis() - start + "ms");
		LOGGER.info("【接口日志】 :" + JSON.toJSONString(webLog));
		return returnValue;
	}

	@SuppressWarnings("rawtypes")
	private Result<?> handlerException(ProceedingJoinPoint point, Throwable e) {
		Result<?> result = new Result();

		// 参数错误异常
		// TODO 统一异常处理，可自行扩展
		if (e instanceof ParaIllegalException) {
			result.setMsg(e.getLocalizedMessage());
			result.setCode(ResultCode.ILLEGALPARA.code);
		} else {
			LOGGER.error(point.getSignature() + " error ", e);
			result.setMsg(e.toString());
			result.setCode(ResultCode.INTERNAL_SERVER_ERROR.code);
		}

		return result;
	}

	private String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		// 如果是多级代理，那么取第一个ip为客户端ip
		if (ip != null && ip.indexOf(",") != -1) {
			ip = ip.substring(0, ip.indexOf(",")).trim();
		}
		return ip;
	}
}
