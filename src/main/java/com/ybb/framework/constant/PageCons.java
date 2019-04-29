package com.ybb.framework.constant;

import lombok.Data;

import java.util.List;

@Data
public class PageCons<T> {

    /**
     * 查询起始
     */
    private int draw;

    /**
     * 查询起始
     */
    private int start;

    /**
     * 查询每页长度
     */
    private int length;

    /**
     * 查询总数
     */
    private long recordsTotal;

    /**
     * 查询过滤记录
     */
    private long recordsFiltered;

    /**
     * 查询数据
     */
    private List<T> data;

}
