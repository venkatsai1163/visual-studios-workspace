package Ass3.OneToOne.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


// TODO: Auto-generated Javadoc
/**
 * The Class LoggerAspect.
 */
@Aspect
@Component
public class LoggerAspect {

    /** The log. */
    private Logger log = LoggerFactory.getLogger(LoggerAspect.class);

    /** The request. */
    @Autowired
    private HttpServletRequest request;

    /**
     * Log controller.
     */
    @Pointcut(
            value = "execution( * Ass3.OneToOne.Controller.*.*(..))"
    )
    public void logController(){}

    /**
     * Log service.
     */
    @Pointcut(
            value = "execution( * Ass3.OneToOne.Service.*.*(..))"
    )
    public void logService(){}

    /**
     * Log main.
     */
    @Pointcut(
            value = "execution( * Ass3.OneToOne.OneToOneApplication.*(..))"
    )
    public void logMain(){}

    /**
     * Controller logger.
     *
     * @param pjp the pjp
     * @return the object
     * @throws Throwable the throwable
     */
    @Around(
            value = "logController()"
    )
    public Object controllerLogger(ProceedingJoinPoint pjp) throws Throwable {

        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] array = pjp.getArgs();
        Object res;
        try{

            log.info("requested url -> [ http:" + request.getServerPort() + "" + request.getRequestURI() + " ] method : [ " + request.getMethod() + " ]");
            log.info(" method invoked " + className + " : " + methodName + "() arguments : " + array + " >>>");
            res = pjp.proceed();
            log.info("Response : [ " + res + " ]");
            log.info(className + " : " + methodName + "() <<<");
        }
        catch (Exception e) {

            log.error("Error Message [ "+ e.getMessage() +" ]");
            log.info( className + " : " + methodName + "() <<<");
            throw e;
        }

        return res;
    }

    /**
     * Service logger.
     *
     * @param pjp the pjp
     * @return the object
     * @throws Throwable the throwable
     */
    @Around(
            value = "logService()"
    )
    public Object serviceLogger(ProceedingJoinPoint pjp) throws Throwable {

        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] array = pjp.getArgs();
        Object res;
        try{

            log.info(" method invoked " + className + " : " + methodName + "() arguments : " + array + " >>>");
            res = pjp.proceed();
            log.info("Response : [ " + res + " ]");
            log.info(className + " : " + methodName + "() <<<");
        }
        catch (Exception e) {

            log.error("Error Message [ "+ e.getMessage() +" ]");
            log.info( className + " : " + methodName + "() <<<");
            throw e;
        }
        return res;
    }

}
