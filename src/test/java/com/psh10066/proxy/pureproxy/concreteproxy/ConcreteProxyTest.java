package com.psh10066.proxy.pureproxy.concreteproxy;

import com.psh10066.proxy.pureproxy.concreteproxy.code.ConcreteClient;
import com.psh10066.proxy.pureproxy.concreteproxy.code.ConcreteLogic;
import org.junit.jupiter.api.Test;

class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();
    }
}
