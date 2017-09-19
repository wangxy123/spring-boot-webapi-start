package com.iflytek.springbootinterfacestart.model.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xywang
 * @create 2017-09-19 23:05
 **/
@Data
public class TestResp implements Serializable {

    private static final long serialVersionUID = 1L;

    private String data;
}
