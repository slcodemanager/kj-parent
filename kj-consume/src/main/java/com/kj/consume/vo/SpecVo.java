package com.kj.consume.vo;

import com.kj.consume.entity.KProductSpec;

import java.io.Serializable;
import java.util.List;

/**
 * @author quan
 * @date 2021-01-18 16:17
 */

public class SpecVo  implements Serializable {
    private static final long serialVersionUID = 2514221142043668058L;
    private String title;
    private List<KProductSpec> attr;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<KProductSpec> getAttr() {
        return attr;
    }

    public void setAttr(List<KProductSpec> attr) {
        this.attr = attr;
    }
}
