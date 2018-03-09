package com.testlog.catchlogs;

import java.io.ByteArrayOutputStream;

import org.apache.log4j.Appender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.journaldev.log4j.main.Log4jExample;

public class LoggingTextListenerTest {
	
	private static final String APPENDER_NAME = "log4jRuleAppender";
	private static final Layout LAYOUT = new SimpleLayout();
	 
	private Logger logger;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	 
	@Before
	public void setupAppender() {
		logger = Logger.getLogger(Log4jExample.class);
		Appender appender = new WriterAppender(LAYOUT, outContent);
		appender.setName(APPENDER_NAME);
		logger.addAppender(appender);
	}
 
    @Rule 
    public LogAppenderResource appender = new LogAppenderResource(Logger.getLogger(Log4jExample.class)); 
    private Log4jExample listener = new Log4jExample(); // Class under test
 
    @Test
    public void startedEvent_isLogged() {
    	
    	String args[] = {"a","b"};
    	
        listener.main(args);
        System.out.println("Testttttttttttttttt"+appender.getOutput());
//        assertThat(appender.getOutput(), containsString("started"));
    }
    
    @Test
    public void testAgain() {
    	
        listener.testlog();
        System.out.println("test 222222222222 "+appender.getOutput());
//        assertThat(appender.getOutput(), containsString("started"));
    }
}
