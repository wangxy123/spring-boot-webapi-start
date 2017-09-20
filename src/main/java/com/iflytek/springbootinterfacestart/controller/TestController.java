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

import com.iflytek.springbootinterfacestart.exception.ParaIllegalException;
import com.iflytek.springbootinterfacestart.model.Result;
import com.iflytek.springbootinterfacestart.model.req.TestReq;
import com.iflytek.springbootinterfacestart.service.TestService;

import static com.iflytek.springbootinterfacestart.common.util.WebLogUtil.*;

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
			BindingResult result) {

		operateLog("TestController.test.in");

		// spring @Valid 做参数验证
		// 可以替换为自己写的验证工具类
		if (result.hasErrors()) {
			throw new ParaIllegalException(result.getFieldError().toString());
		}

		return new Result<TestResp>(testService.test());
	}
}
