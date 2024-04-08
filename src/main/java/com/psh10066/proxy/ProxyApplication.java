package com.psh10066.proxy;

import com.psh10066.advanced.trace.logtrace.LogTrace;
import com.psh10066.advanced.trace.logtrace.ThreadLocalLogTrace;
import com.psh10066.proxy.config.AppV1Config;
import com.psh10066.proxy.config.AppV2Config;
import com.psh10066.proxy.config.v1_proxy.ConcreteProxyConfig;
import com.psh10066.proxy.config.v1_proxy.InterfaceProxyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import({AppV1Config.class, AppV2Config.class})
@Import({InterfaceProxyConfig.class, ConcreteProxyConfig.class})
@SpringBootApplication(scanBasePackages = "com.psh10066.proxy.app.v3") // 컴포넌트 스캔 피하기
public class ProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
