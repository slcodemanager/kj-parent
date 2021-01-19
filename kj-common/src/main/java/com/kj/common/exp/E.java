package com.kj.common.exp;

/**
 * 自定义异常
 *
 * @author quan
 * @date 2020-11-27 14:26
 */

public class E extends RuntimeException {
    public E(String msg) {
        super(msg);
    }
}
