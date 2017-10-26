package com.iflytek.springbootinterfacestart.common.util;

import com.iflytek.springbootinterfacestart.model.entity.Operation;
import com.iflytek.springbootinterfacestart.model.entity.WebLog;

/**
 * @ClassName: WebLogUtil
 * @Description: 记录接口请求日志工具类，使用ThreadLocal
 * @author xywang
 * @date 2017年9月20日 上午9:23:23
 * 
 */
public class WebLogUtil {
	// 线程变量 日志对象
	private final static ThreadLocal<WebLog> log = new ThreadLocal<WebLog>() {
		@Override
		protected WebLog initialValue() {
			return new WebLog();
		}
	};

	public static void operateLog(String logmsg) {
		log.get().getOperates().add(new Operation(logmsg));
	}

	public static WebLog getLog() {
		return log.get();
	}
}
