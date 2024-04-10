package com.psh10066.aop.exam;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamService {

    public final ExamRepository examRepository;

    public void request(String itemId) {
        examRepository.save(itemId);
    }
}
