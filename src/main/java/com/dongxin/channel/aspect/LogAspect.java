package com.dongxin.channel.aspect;

import com.dongxin.channel.domain.ChannelHandleLog;
import com.dongxin.channel.domain.ChannelUserLogin;
import com.dongxin.channel.myannotation.NeedLog;
import com.dongxin.channel.service.ChannelHandleLogService;
import com.dongxin.channel.util.CommonUtil;
import com.dongxin.channel.util.HttpUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 用于记录日志的Aspect
 *
 * @author yusongyuan
 * @create 2018-01-02 18:02
 **/
@Aspect // 注解声明一个切面
@Component // 受spring管理的容器
public class LogAspect {

    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);
    @Autowired
    private ChannelHandleLogService channelHandleLogService;
    
    //扫描service下面的
    @Pointcut("execution(public * com.dongxin.channel.service..*(..))")
    public void handleLog(){}

    @Before("handleLog()")
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        NeedLog needLog = method.getAnnotation(NeedLog.class);
        if (needLog != null) {
            logger.info("---------这是NeedLog-----Before");
        }
    }

    /**
     * 获取service返回值,添加渠道操作日志
     *
     * @param object
     * @param joinPoint
     */
    @AfterReturning(returning = "object", pointcut = "handleLog()")
    public void after(JoinPoint joinPoint, Object object) {
        //获取方法相关信息
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        NeedLog needLog = method.getAnnotation(NeedLog.class);
        if (needLog != null) {
            //如果返回类型为ChannelUserLogin实体类
            if (object.getClass() == ChannelUserLogin.class) {
                ChannelUserLogin user = (ChannelUserLogin)object;
                //获取请求相关
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                //获取登录者的操作ip
                String logip = HttpUtil.getIpAddr(attributes.getRequest());
                ChannelHandleLog handleLog = new ChannelHandleLog(user.getUsername(), user.getMeno(), logip, needLog.handleInfo());
                //插入渠道操作日志
                channelHandleLogService.insertHandleLog(handleLog);
            }
        }
    }

}
