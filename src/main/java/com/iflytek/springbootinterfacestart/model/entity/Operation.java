package com.iflytek.springbootinterfacestart.model.entity;

import java.util.Date;

import lombok.Data;

import org.apache.commons.lang3.time.FastDateFormat;

/**
 * @ClassName: Operate
 * @author xywang
 * @date 2017年8月19日 下午3:06:11
 * 
 */
@Data
public class Operation {

	private String operateName;
	private String time;

	public Operation(String _operateName) {
		this.operateName = _operateName;
		this.time = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss:SSS")
				.format(new Date());
	}
}
