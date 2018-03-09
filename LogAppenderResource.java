package com.testlog.catchlogs;

import org.apache.log4j.Appender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;
import org.junit.rules.ExternalResource;
 
import java.io.ByteArrayOutputStream;
 
public class LogAppenderResource extends ExternalResource {
 
    private static final String APPENDER_NAME = "log4jRuleAppender";
    private static final Layout LAYOUT = new SimpleLayout();
 
    private Logger logger;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
 
    public LogAppenderResource(Logger logger) {
        this.logger = logger;
    }
 
    @Override
    protected void before() {
        Appender appender = new WriterAppender(LAYOUT, outContent);
        appender.setName(APPENDER_NAME);
        logger.addAppender(appender);
    }
 
    @Override
    protected void after() {
        logger.removeAppender(APPENDER_NAME);
    }
 
    public String getOutput() {
        return outContent.toString();
    }
}