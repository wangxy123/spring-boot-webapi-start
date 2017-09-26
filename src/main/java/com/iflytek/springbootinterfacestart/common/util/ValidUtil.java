package com.iflytek.springbootinterfacestart.common.util;

import com.iflytek.springbootinterfacestart.exception.ParaIllegalException;

/**
 * @ClassName: ValidUtil
 * @Description: 参数校验工具类
 * @author xywang
 * @date 2017年9月20日 上午10:38:56
 * 
 */
public class ValidUtil {

	public static void check(boolean condition, String paraName) {
		if (!condition) {
			fail(paraName);
		}
	}

	public static void notEmpty(String paraValue, String paraName) {
		if (paraValue == null || paraValue.isEmpty()) {
			fail(paraName);
		}
	}

	public static void notNull(Object paraValue, String paraName) {
		if (paraValue == null) {
			fail(paraName);
		}
	}

	private static void fail(String paraName) {
		throw new ParaIllegalException("参数错误：" + paraName);
	}
}
