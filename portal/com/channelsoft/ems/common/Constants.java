package com.channelsoft.ems.common;

import org.apache.commons.lang.StringUtils;

/**
 * 根据数据库返回的状态标识（0,1...）处理后加上说明返回到前台
 * Created by wangjs on 2016/12/6.
 */
public enum Constants {

        ELSE("","未知状态"),
//        INIT("0","初始"),
//        UPDATE_SUCCESS("1","录音信息更新成功"),
//        UPDATE_FAIL("2","录音信息更新失败"),
//        FILE_EXISTS("3","录音文件存在"),
//        FILE_NOT_EXIST("4","录音文件不存在"),
//        DOWNLOAD_SUCCESS("5","文件下载成功"),
//        DOWNLOAD_FAIL("6","文件下载失败"),
//        LOCKED("7","锁定");
        OPEN("11","开启"),
        DISABLE("10","禁用"),
        fisTrue("1","是"),
        fisFalse("0","否");

        public String value;
        public String desc;

        Constants(String value, String desc){
            this.value = value;
            this.desc = desc;
        }

        public static Constants getEnum(String value){
            //比较两个字符串是否相等，不区分大小写，如果两个均为空则也认为相等。
            for(Constants e:values()){
                if(StringUtils.equalsIgnoreCase(e.value, value)){
                    return e;
                }
            }
            return ELSE;
        }

}
