/**    
 * @Title: TestController.java  
 * @Package com.iflytek.springbootinterfacestart.Controller  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author xywang   
 * @date 2017年9月19日 上午10:25:01  
 * @version V1.0    
 */
package com.iflytek.springbootinterfacestart.controller;

import javax.validation.Valid;

import com.iflytek.springbootinterfacestart.model.resp.TestResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

import com.iflytek.springbootinterfacestart.exception.ParaIllegalException;
import com.iflytek.springbootinterfacestart.model.Result;
import com.iflytek.springbootinterfacestart.model.entity.Operation;
import com.iflytek.springbootinterfacestart.model.entity.WebLog;
import com.iflytek.springbootinterfacestart.model.req.TestReq;
import com.iflytek.springbootinterfacestart.service.TestService;

/**
 * @ClassName: TestController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author xywang
 * @date 2017年9月19日 上午10:25:01
 * 
 */
@RestController
public class TestController {

	@Autowired
	TestService testService;

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public Result<TestResp> test(@RequestBody @Valid TestReq req,
								 BindingResult result, @ApiIgnore WebLog webLog) {
		webLog.getOperates().add(new Operation("TestController.test.in"));

		if (result.hasErrors()) {
			throw new ParaIllegalException(result.getFieldError().toString());
		}

		return new Result<TestResp>(testService.test(webLog));
	}
}
