package com.psh10066.advanced.trace.template;

import com.psh10066.advanced.trace.TraceStatus;
import com.psh10066.advanced.trace.logtrace.LogTrace;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    public T execute(String message) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            // 로직 호출
            T result = call();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call();
}
