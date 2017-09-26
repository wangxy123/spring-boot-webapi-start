package com.iflytek.springbootinterfacestart.common.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName: NotStringNullImpl
 * @Description: 判断参数不为“null” 或“NULL”
 * @author xywang
 * @date 2017年9月20日 上午9:19:30
 * 
 */
public class NotStringNullImpl implements
		ConstraintValidator<NotStringNull, String> {

	/*
	 * (非 Javadoc) <p>Title: initialize</p> <p>Description: </p>
	 * 
	 * @param arg0
	 * 
	 * @see
	 * javax.validation.ConstraintValidator#initialize(java.lang.annotation.
	 * Annotation)
	 */
	@Override
	public void initialize(NotStringNull arg0) {
	}

	/*
	 * (非 Javadoc) <p>Title: isValid</p> <p>Description: </p>
	 * 
	 * @param arg0
	 * 
	 * @param arg1
	 * 
	 * @return
	 * 
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {

		if (arg0 == null)
			return true;
		return (!arg0.equals("null")) && (!arg0.equals("NULL"));
	}
}
