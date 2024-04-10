package com.psh10066.aop.internalcall;

import com.psh10066.aop.internalcall.aop.CallLogAspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(CallLogAspect.class)
@SpringBootTest
class CallServiceV0Test {

    @Autowired
    CallServiceV0 callServiceV0;

    @Test
    void external() {
        callServiceV0.external(); // 내부에서 internal을 호출할 때 AOP 적용 X
    }

    @Test
    void internal() {
        callServiceV0.internal();
    }
}