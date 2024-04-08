package com.psh10066.proxy.config.v1_proxy;

import com.psh10066.advanced.trace.logtrace.LogTrace;
import com.psh10066.proxy.app.v1.*;
import com.psh10066.proxy.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import com.psh10066.proxy.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import com.psh10066.proxy.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {

    @Bean
    public OrderControllerV1 orderController(LogTrace logTrace) {
        OrderControllerV1Impl controllerImpl = new OrderControllerV1Impl(orderService(logTrace));
        return new OrderControllerInterfaceProxy(controllerImpl, logTrace);
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace logTrace) {
        OrderServiceV1Impl serviceImpl = new OrderServiceV1Impl(orderRepository(logTrace));
        return new OrderServiceInterfaceProxy(serviceImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace) {
        OrderRepositoryV1Impl repositoryImpl = new OrderRepositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(repositoryImpl, logTrace);
    }
}
