package com.dongxin.channel.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * HttpAop处理
 *
 * @author yusongyuan
 * @create 2017-12-22 13:15
 **/
@Aspect
@Component //引入到spering boot容器中
public class HttpAspect {

    private final static Logger loger = LoggerFactory.getLogger(HttpAspect.class);



    //@Pointcut:表示声明一个切面，且中的语句不会执行
    @Pointcut("execution(public * com.dongxin.channel.controller..*(..))")
    public void log(){}

    //JoinPoint:用于获取请求的方法的具体信息
    @Before("log()")
    public void beforeLog(JoinPoint joinPoint){
        loger.info("--------进入beforeLog方法：@Before");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //请求的链接
        loger.info("url={}", request.getRequestURL()+"&"+request.getQueryString());
        //请求的方式 POST GET
        loger.info("method={}", request.getMethod());
        //请求的ip
        loger.info("ip={}", request.getRemoteAddr());
        //请求的方法 getDeclaringTypeName()：类名； getName():获取方法名
        loger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //请求的参数
        StringBuffer args = new StringBuffer();
        for (Object o : joinPoint.getArgs()) {
            args.append(o.toString()+", \t");
        }
        loger.info("arg={}", args.toString());
    }

    @After("log()")
    public void afterLog(){
        loger.info("--------进入afterLog方法：@After");

    }

    //不匹配的方法：无返回值 void
    @Pointcut("execution(public void com.dongxin.channel.controller..*(..))")
    public void voidNotLog(){}

    //对于本次请求，响应的数据
    //获取响应的数据 returning = "object" 是等于 Object object
    @AfterReturning(returning = "object" , pointcut = "log() and !voidNotLog()")
    public void afterReturningLog(Object object){
        loger.info("response={}", object.toString());
    }

}
