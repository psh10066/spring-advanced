package com.psh10066.advanced.trace.callback;

import com.psh10066.advanced.trace.TraceStatus;
import com.psh10066.advanced.trace.logtrace.LogTrace;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TraceTemplate {

    private final LogTrace trace;

    public <T> T execute(String message, TraceCallback<T> callback) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            // 로직 호출
            T result = callback.call();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
