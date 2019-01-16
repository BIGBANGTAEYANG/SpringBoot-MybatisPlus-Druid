package com.ybb.framework;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ybb.framework.constant.PageCons;
import com.ybb.framework.util.TypeUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuperController {
    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;


}
