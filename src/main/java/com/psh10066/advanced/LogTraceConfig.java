package com.psh10066.advanced;

import com.psh10066.advanced.trace.logtrace.FieldLogTrace;
import com.psh10066.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new FieldLogTrace();
    }
}
