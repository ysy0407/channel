package com.dongxin.channel.util;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用工具类
 *
 * @author yusongyuan
 * @create 2018-01-03 11:30
 **/

public class CommonUtil<T> {

    /**
     * 获取当前日期
     * @return
     */
    public static String getNowDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
        return sdf.format(new Date());
    }

    /**
     * 将泛型的class转为map
     * @param t
     * @return
     */
    public Map<String, Object> classToMap(T t){
        Map<String, Object> map = new HashMap<String, Object>();
        //将属性存为列表
        Field[] field = t.getClass().getDeclaredFields();
        for (Field f:field) {
            f.setAccessible(true);
            try{
                //将泛型中的属性名称和属性值放入到map中
                map.put(f.getName(),f.get(t));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return map;
    }





}
