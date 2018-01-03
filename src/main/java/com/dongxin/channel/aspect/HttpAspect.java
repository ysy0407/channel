package com.dongxin.channel.aspect;

import com.dongxin.channel.domain.ChannelUserLogin;
import com.dongxin.channel.exception.MyException;
import com.dongxin.channel.myenum.MyEnum;
import com.dongxin.channel.util.HttpUtil;
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

    //不用拦截的方法或controller类
    private final static String[] NOT_ASPECT_CONTROLLER = {"com.dongxin.channel.controller.UserController.login",
                                                            "com.dongxin.channel.controller.VaildCodeController"};



    //@Pointcut:表示声明一个切面，且中的语句不会执行
    @Pointcut("execution(public * com.dongxin.channel.controller..*(..))")
    public void log(){}

    //JoinPoint:用于获取请求的方法的具体信息
    //拦截controller的所有方法,除了登录方法
    @Before("log()")
    public void beforeLog(JoinPoint joinPoint) throws MyException{
        loger.info("--------进入beforeLog方法：@Before");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpUtil.setHttpSession(request.getSession());
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
        //不拦截的直接进入方法,需要拦截的则判断session[user]是否为null,或操作的用户id是否和session中的相同
        if (isAspect(joinPoint)) {
            ChannelUserLogin user = (ChannelUserLogin)HttpUtil.getSessionAttribute("user");
            //所有拦截的方法第一个参数为id
            int argID = (int)joinPoint.getArgs()[0];
            if(user == null || argID != user.getId()){
                throw new MyException(MyEnum.ERR_1004);
            }
        }

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
    public void afterReturningLog(JoinPoint joinPoint, Object object){

        loger.info("response={}", object.toString());
    }

    /**
     * 请求的方法是否包含在不拦截的数组中 返回false, 否则返回true
     *
     * @param joinPoint
     * @return
     */
    private boolean isAspect(JoinPoint joinPoint){
        //请求的方法全路径
        String requestMethodPath = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        for (String path : NOT_ASPECT_CONTROLLER) {
            if (requestMethodPath.contains(path)) {
                return false;
            }
        }
        return true;
    }

}
