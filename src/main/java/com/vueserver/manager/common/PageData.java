package com.vueserver.manager.common;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: hetao
 * @create: 2020-06-06 19:02
 **/
@Data
public class PageData {

    private Object items;
    private Long total;

    public PageData(Object items, Long total) {
        this.items = items;
        this.total = total;
    }

    public PageData() {
    }
}
