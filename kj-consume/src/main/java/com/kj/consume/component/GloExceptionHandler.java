package com.kj.consume.component;



import com.kj.common.exp.E;
import com.kj.common.result.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author quan
 * @date 2020-11-24 15:55
 */

@RestControllerAdvice
public class GloExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GloExceptionHandler.class);

    @ExceptionHandler({Exception.class,E.class})
    public R exp(Exception e) {
        log.error("Exception:{}", e.getMessage());
        return R.err(e.getMessage());
    }
}
