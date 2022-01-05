package com.yb.datapipeline.exception;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@Aspect
public class GlobalExceptionHandler {
    private final static String EXECUTION = "execution(* com.yb.datapipeline.ability..*.*(..)) || execution(* com.yb.datapipeline.ext..*.*(..)) || execution(* com.yb.datapipeline.controller..*.*(..)) ";

    /**
     * 切入点可以添加其他路径
     */
    @Pointcut(EXECUTION)
    private void pointCutMethod() {
    }

    /***
     * @param jPoint
     * @return
     * @throws Throwable
     */
    @Around("pointCutMethod()")
    public Object aroundLog(ProceedingJoinPoint jPoint) throws Throwable {
        Object result = null;
        try {
            result = jPoint.proceed();
        } catch (DataPipelineException de) {
            log.error("DataPipelineException info {}", de);
            de.printStackTrace();
        } catch (RuntimeException re) {
            log.error("RuntimeException info {}", re);
            re.printStackTrace();
        } catch (Exception e) {
            log.error("Exception info {}", e);
            e.printStackTrace();
        } catch (Throwable t){
            log.error("error info {}", t);
            t.printStackTrace();
        }
        return result;
    }
}
