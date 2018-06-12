package com.channelsoft.ems.common;

import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Config {
	private static Properties properties = null;
	private static Logger logger = Logger.getLogger(Config.class);
	
	public static final String DB_MONGO_ASSEMBLY = "db_mongo_assembly";
	
	public static final String MONGO_DBNAME = "db_mongo_name";
	public static final String MONGO_COLLNAME = "db_monge_collname";
	public static final String GLSWEBSERVICE_URL = "app.gls.webservice.url";
	
	//企业dds事件推送队列最大长度
	public static final String MAX_BLOCK_QUEUE = "max.block.queue";
	//企业dds事件推送接口超时时长
	public static final String HTTP_MAX_TIMEOUT = "http.max.timeout";
	//企业dds事件推送线程接口调用失败容忍次数
	public static final String HTTP_TIME_OUTS = "http.timeouts";
	//企业dds线程检查dds重启时间间隔
	public static final String DDS_REFRESH_INTERVAL = "dds.refresh.interval";
	//数据推送接口调用失败时收件人
	public static final String DATAPUSH_RECEIVER = "datapush.receiver";
	
	static {
		loadProperties();
	}
	private static void loadProperties() {
		try {
			logger.debug("读取属性文件[config.properties]....");
			properties = new Properties();
			properties.load(new InputStreamReader(Config.class.getClassLoader()
					.getResourceAsStream("properties/config.properties"), "GBK"));
		} catch (Exception e) {
			logger.error("读取属性文件[config.properties]失败.");
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static void reloadProperties() {
		loadProperties();
	}

	private Config() {
	}

	public static String getString(String key) {
		return properties.getProperty(key);
	}

	public static String getString(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	public static int getInt(String key) {
		return Integer.parseInt(getString(key));
	}

	public static int getInt(String key, int defaultValue) {
		return Integer.parseInt(getString(key, String.valueOf(defaultValue)));
	}
}
