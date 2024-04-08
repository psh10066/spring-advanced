package com.psh10066.proxy.pureproxy.decorator;

import com.psh10066.proxy.pureproxy.decorator.code.Component;
import com.psh10066.proxy.pureproxy.decorator.code.DecoratorPatternClient;
import com.psh10066.proxy.pureproxy.decorator.code.MessageDecorator;
import com.psh10066.proxy.pureproxy.decorator.code.RealComponent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class DecoratorPatternTest {

    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

    @Test
    void decorator1() {
        Component realComponent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
        client.execute();
    }
}
