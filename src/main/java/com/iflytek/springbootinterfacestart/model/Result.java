package com.iflytek.springbootinterfacestart.model;

import java.io.Serializable;

import lombok.Data;

import com.iflytek.springbootinterfacestart.common.ResultCode;

/**
 * @ClassName: Result
 * @author xywang
 * @date 2017年9月19日 上午10:01:16
 * 
 */
@Data
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private String returndesc;

	private String returncode;

	private T data;

	public Result() {
		super();
		this.returndesc = ResultCode.SUCCESS.returndesc;
		this.returncode = ResultCode.SUCCESS.returncode;
	}

	public Result(T data) {
		super();
		this.returndesc = ResultCode.SUCCESS.returndesc;
		this.returncode = ResultCode.SUCCESS.returncode;
		this.data = data;
	}

	public Result(Throwable e) {
		super();
		this.returndesc = e.toString();
		this.returncode = ResultCode.INTERNAL_SERVER_ERROR.returncode;
	}
}
