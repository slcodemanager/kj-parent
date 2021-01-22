package com.kj.consume.component;


import com.kj.common.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author quan
 * @date 2020-11-28 15:18
 */
@Component
public class SnowFlakeComponent {
    @Value("${snowflake.machineid}")
    private long machineid;
    @Value("${snowflake.datacenterid}")
    private long datacenterid;

    private static volatile SnowFlake instance;


    public Long num() {
        return snowFlake().nextId();
    }

    public String str() {
        return snowFlake().nextId() + "";
    }

    private SnowFlake snowFlake() {
        if (instance == null) {
            synchronized (this) {
                if (instance == null) {
                    instance = new SnowFlake(datacenterid, machineid);
                }
            }
        }
        return instance;
    }
}
