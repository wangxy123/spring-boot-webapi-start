package com.iflytek.springbootinterfacestart.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


/**  
 * @ClassName: NotStringNull  
 * @Description: 判断参数不为“null” 或“NULL”
 * @author xywang 
 * @date 2017年9月20日 上午9:18:40  
 *    
 */
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE})  
@Retention(RetentionPolicy.RUNTIME)  
@Constraint(validatedBy = NotStringNullImpl.class)  
public @interface NotStringNull {

	String message() default "参数为'null'或'NULL'";  
	  
    Class<?>[] groups() default {};  
  
    Class<? extends Payload>[] payload() default {};  
}
