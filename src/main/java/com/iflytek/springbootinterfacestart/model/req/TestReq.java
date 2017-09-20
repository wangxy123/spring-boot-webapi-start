package com.iflytek.springbootinterfacestart.model.req;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Repository;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName: TestReq
 * @author xywang
 * @date 2017年9月19日 上午11:03:35
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Repository
public class TestReq extends BaseReq {

	private static final long serialVersionUID = 1L;
	@NotBlank
	private String testName;
	@NotBlank
	private String testPassword;
}
