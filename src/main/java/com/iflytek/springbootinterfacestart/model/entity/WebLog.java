package com.iflytek.springbootinterfacestart.model.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * @ClassName: WebLog
 * @author xywang
 * @date 2017年8月19日 下午2:44:20
 * 
 */
@Data
public class WebLog {
	private String url;
	private String http_method;
	private String ip;
	private String class_method;
	private String webargs;
	private List<Operation> operates;
	private String ret;
	private String time;

	public WebLog() {
		operates = new ArrayList<Operation>();
	}
}
