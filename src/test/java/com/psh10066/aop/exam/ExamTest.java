package com.psh10066.aop.exam;

import com.psh10066.aop.exam.aop.RetryAspect;
import com.psh10066.aop.exam.aop.TraceAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@Import({TraceAspect.class, RetryAspect.class})
@SpringBootTest
class ExamTest {

    @Autowired
    ExamService examService;

    @Test
    void test() {
        for (int i = 1; i <= 5; i++) {
            log.info("client request i={}", i);
            examService.request("data" + i);
        }
    }
}
