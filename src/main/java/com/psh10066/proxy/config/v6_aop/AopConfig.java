package com.psh10066.proxy.config.v6_aop;

import com.psh10066.advanced.trace.logtrace.LogTrace;
import com.psh10066.proxy.config.AppV1Config;
import com.psh10066.proxy.config.AppV2Config;
import com.psh10066.proxy.config.v6_aop.aspect.LogTraceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class AopConfig {

    @Bean
    public LogTraceAspect logTraceAspect(LogTrace logTrace) {
        return new LogTraceAspect(logTrace);
    }
}
