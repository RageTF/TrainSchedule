package spring.aspect;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 * Created by Rage on 05.05.2017.
 */
public class EntityAspect {

    private Logger logger;

    private Logger mLogger;

    public void init(){
        mLogger=Logger.getRootLogger();
        mLogger.setLevel(Level.INFO);
        PatternLayout layout = new PatternLayout("%d{ISO8601} [%t] %-5p %c %x - %m%n");
        mLogger.addAppender(new ConsoleAppender(layout));
    }

    public void before(){
        mLogger.info("BeforeServiceRequest");
    }

    public void after(){
        mLogger.info("AfterServiceRequest");
    }

    public void beforeReturning(){
        mLogger.info("BeforeReturning");
    }

    public void afterThrowing(){
        mLogger.info("AfterThrowing");
    }

}
