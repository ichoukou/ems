package com.channelsoft.ems.common;

import java.util.HashMap;
import java.util.Iterator;

import com.alibaba.fastjson.JSONObject;

public class JsonUtils {

	/**
	 * 将json格式的字符串解析成Map对象 <li>
	 * json格式：{"name":"admin","retries":"3fff","testname"
	 * :"ddd","testretries":"fffffffff"}
	 */
	
	public static HashMap<String, Object> jsonToMap(String json) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		// 将json字符串转换成jsonObject
		JSONObject jsonObject = JSONObject.parseObject(json);
		Iterator it = jsonObject.keySet().iterator();
		// 遍历jsonObject数据，添加到Map对象
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			String value = String.valueOf(jsonObject.get(key));
			data.put(key, value);
		}
		return data;
	}

}
