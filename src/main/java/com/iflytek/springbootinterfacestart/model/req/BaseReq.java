/**    
* @Title: BaseReq.java  
* @Package com.iflytek.springbootinterfacestart.model.req  
* @Description: TODO(用一句话描述该文件做什么)  
* @author xywang   
* @date 2017年9月19日 上午11:02:41  
* @version V1.0    
*/
package com.iflytek.springbootinterfacestart.model.req;

import java.io.Serializable;

import lombok.Data;

/**  
 * @ClassName: BaseReq
 * @author xywang 
 * @date 2017年9月19日 上午11:02:41  
 *    
 */
@Data
public class BaseReq implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String seq;

}
