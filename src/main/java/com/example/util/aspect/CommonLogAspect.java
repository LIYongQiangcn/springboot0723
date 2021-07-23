package com.example.util.aspect;

import com.example.util.annotation.LogAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Yongqiang.li
 * @Aspect AOP 切面
 */
@Aspect
@Component
@Slf4j
public class CommonLogAspect {

    /**
     * 通过@Pointcut指定切入点 ，这里指定的切入点为LogAnnotation注解类型，也就是
      被@LogAnnotation注解修饰的方法，进入该切入点
     */
    @Pointcut(value = "@annotation(com.example.util.annotation.LogAnnotation)")
    private void pointcut() {

    }

    /**
     * 在方法执行前后
     *
     * @param joinPoint
     * @param logA
     * @return
     */
    @Before(value = "pointcut() && @annotation(logA)")
    public void around(JoinPoint joinPoint, LogAnnotation logA) {

        System.out.println("自定义日志注解开始执行");
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return;
        }
        HttpServletRequest request = attributes.getRequest();

        String msg = logA.desc();
        //拦截的方法
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();

        System.out.println(" 方法:" + method + " 自定义消息:" + msg);

        log.info("--------------->日志打印ing<------------- : ");
        log.info("---->请求URL : " + request.getRequestURL().toString());
        log.info("---->HTTP方法 : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("---->方法名 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("---->参数值 : " + Arrays.toString(joinPoint.getArgs()));

    }

    /**
     * 方法执行后
     *
     * @param logA
     * @param result
     * @return
     */
    @AfterReturning(value = "pointcut() && @annotation(logA)", returning = "result")
    public void afterReturning(LogAnnotation logA, Object result) {
        log.info("result: "+ result);
    }

    /**
     * 方法执行后 并抛出异常
     *
     * @param joinPoint
     * @param logAnnotation
     * @param ex
     */
    @AfterThrowing(value = "pointcut() && @annotation(logAnnotation)", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, LogAnnotation logAnnotation, Exception ex) {
        System.out.println("执行了afterThrowing方法");
        System.out.println("请求：" + logAnnotation.desc() + " 出现异常");
    }

}