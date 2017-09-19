/**    
 * @Title: ParaIllegalException.java  
 * @Package com.iflytek.springbootinterfacestart.exception  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author xywang   
 * @date 2017年9月19日 下午1:05:04  
 * @version V1.0    
 */
package com.iflytek.springbootinterfacestart.exception;

/**
 * @ClassName: ParaIllegalException
 * @Description: 参数格式错误异常
 * @author xywang
 * @date 2017年9月19日 下午1:05:04
 * 
 */
public class ParaIllegalException extends RuntimeException {

	/**
	 * @Fields serialVersionUID 
	 */
	private static final long serialVersionUID = -4227850117731228650L;

	public ParaIllegalException() {
		super();
	}

	public ParaIllegalException(String message) {
		super(message);
	}

	public ParaIllegalException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParaIllegalException(Throwable cause) {
		super(cause);
	}

	protected ParaIllegalException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
