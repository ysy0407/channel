package com.dongxin.channel.util;

import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 获取模板文件的工具类
 *
 * 模板保存在excel-templates/  下面
 *
 * @author yusongyuan
 * @create 2018-01-04 17:00
 **/

public class TemplateFileUtil {

    public static FileInputStream getTemplates(String tempName) throws FileNotFoundException {
        return new FileInputStream(ResourceUtils.getFile("classpath:excel-templates/"+tempName));
    }

}
