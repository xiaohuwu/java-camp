package com.example.springboot16redis;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.spi.FilterReply;
import org.slf4j.Marker;

public class MyTurboFilter extends TurboFilter {
    @Override
    public FilterReply decide(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable t) {
        if (level == Level.TRACE && logger.getName().equals("org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod")) {
            logger.trace(marker, format, params);
            return FilterReply.DENY;
        }
        return FilterReply.NEUTRAL;
    }
}
