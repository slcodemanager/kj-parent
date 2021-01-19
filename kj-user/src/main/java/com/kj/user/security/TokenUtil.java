package com.kj.user.security;

import org.springframework.stereotype.Component;

/**
 * @author 胡耀东
 * @version 1.0
 * Description:
 * @date 2021/1/16 17:55
 */
@Component
public class TokenUtil {

    //设置token过期时间
    private long tokenExpiration = 0;
}
