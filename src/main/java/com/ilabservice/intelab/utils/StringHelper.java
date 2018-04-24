package com.ilabservice.intelab.utils;

import com.google.common.annotations.VisibleForTesting;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by RedWall on 2017/9/10.
 */
public class StringHelper {
    public static String getObjectValue(Object obj){
        return obj==null?"":obj.toString();
    }

    /**
     * @author RedWall
     * @date 2018/3/6 10:14
     * @param source 源字符串
     * @param separator separator 分割符
     * @return List<String> 切割后返回的字符串集合
     * @description
     */
    public static List<String> splitString(String source, String separator){

        if(StringUtils.isNotBlank(source)){
            String[] result = source.split(separator);
            return Arrays.asList( result);
        }else {
            return Collections.emptyList();
        }
    }

    /**
     * @author RedWall
     * @date 2018/3/7 10:14
     * @param source 源集合
     * @param separator separator 拼接符
     * @return String 拼接后的字符串
     * @description
     */
    public static String mergeString(List<String> source, String separator){

        String result = "";

        if(source != null){
            for (String str : source){
                if("".equals(result)){
                    result = str;
                }else{
                    result = result + "," +str;
                }
            }
        }
        return result;
    }

    /**
     * 将前台参数的undefind转成
     * @param source
     * @return
     */
    public static String[] undefindToNUll(String... source){

        for (String str : source){
            if("undefind".equals(source)){
                str = null;
            }
        }
        return source;
    }

    /**
     * 字符串转整型，报错返回0
     * @param str
     * @return
     */
    public static Integer stringToInteger(String str){
        try{
            return Integer.parseInt(str);
        }catch (Exception e){
            return 0;
        }
    }

}
