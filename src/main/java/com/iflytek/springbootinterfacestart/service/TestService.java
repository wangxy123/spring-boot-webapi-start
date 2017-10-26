package com.iflytek.springbootinterfacestart.service;

import com.iflytek.springbootinterfacestart.model.resp.TestResp;
import org.springframework.stereotype.Service;

import com.iflytek.springbootinterfacestart.model.entity.WebLog;
import static com.iflytek.springbootinterfacestart.common.util.WebLogUtil.*;

/**
 * @ClassName: TestService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author xywang
 * @date 2017年9月19日 上午11:13:02
 * 
 */
@Service
public class TestService {

	public TestResp test() {
		operateLog("TestService.test.in");

		System.out.println(Thread.currentThread().getName());

		return new TestResp();
	}

}
