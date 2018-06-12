package com.channelsoft.ems.common;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 封装各种生成唯一性ID算法的工具类.
 * @author ThinkGem
 * @version 2013-01-15
 */
@Component
@Lazy(false)
public class IdGen{

	private static SecureRandom random = new SecureRandom();
	
	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * <b>功能：</b>17位可用于UUID,订单号<br>
	 * @param str SO:采购订单  CK:出库单  TH:退货单
	 * @return
	 */
	public static String getRandomNo(String str){
		return str + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
	}
	
	/**
	 * <b>功能：</b>17位可用于UUID,订单号<br>
	 * @param str SO:采购订单  CK:出库单  TH:退货单
	 * @return
	 */
	public static String getRandomNoYMS(String str,int number){
		return str + new SimpleDateFormat("yyMMddHHmmss").format(new Date())+ getRandom(number);
	}
	
	/**
	 * <b>功能：</b>12位时间加上number位数<br>
	 */
	public static String getRandomNo(String str,int number) {
		return str + getRandom(number);
	}

	/**
	 * <b>功能：</b>12位时间加上number位数<br>
	 */
	public static Long getUid(int number) {
		return Long.parseLong(new SimpleDateFormat("yyMMddHHmmss").format(new Date()) + getRandom(number));
	}
	
	/**
	 * <b>功能：</b>获取随机数从1开始,格式10000000-99999999<br>
	 * @return
	 */
	public static int getRandom(int number) {
		int max = 9;
		int min = 1;
		for (int i = 1; i < number; i++) {
			min = min * 10;
			max = max * 10 + 9;
		}
		return getRandom(min, max);
	}

	/**
	 * <b>功能：</b>方法功能描述<br>
	 * @return
	 */
	public static int getRandom(int min, int max) {
		// int a = (int) (Math.random() * (44) + 23); //产生的[23,67)的随机数
		return (int) (Math.random() * (max - min) + min);
	}

	/**
	 * 使用SecureRandom随机生成Long. 
	 */
	public static long randomLong() {
		return Math.abs(random.nextLong());
	}
	
}
