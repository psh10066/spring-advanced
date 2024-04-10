package com.psh10066.aop.proxyvs;

import com.psh10066.aop.member.MemberService;
import com.psh10066.aop.member.MemberServiceImpl;
import com.psh10066.aop.proxyvs.code.ProxyDIAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@Import(ProxyDIAspect.class)
//@SpringBootTest(properties = "spring.aop.proxy-target-class=false") // JDK 동적 프록시
@SpringBootTest(properties = "spring.aop.proxy-target-class=true") // CGLIB (default)
class ProxyDITest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberServiceImpl memberServiceImpl; // JDK 동적 프록시 사용 시 주입 실패

    @Test
    void go() {
        log.info("memberService class={}", memberService.getClass());
        log.info("memberServiceImpl class={}", memberServiceImpl.getClass());
        memberServiceImpl.hello("hello");
    }
}
