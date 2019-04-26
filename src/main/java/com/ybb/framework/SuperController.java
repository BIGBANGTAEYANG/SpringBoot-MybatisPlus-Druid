package com.ybb.framework;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuperController {
    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;


}
