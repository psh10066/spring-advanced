package com.psh10066.advanced.trace.logtrace;

import com.psh10066.advanced.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
