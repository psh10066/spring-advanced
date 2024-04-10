package com.psh10066.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 구조를 변경(분리)
 */
@Slf4j
@Component
public class InternalService {

    public void internal() {
        log.info("call internal");
    }
}
