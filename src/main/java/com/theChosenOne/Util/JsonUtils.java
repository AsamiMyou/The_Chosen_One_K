package com.theChosenOne.Util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
/**
 * 
 * @author Asami Myou
 *
 */
public class JsonUtils {

	public static String returnTableVo(Object T) {
		Map<String, Object> testMap = new HashMap<String, Object>();
		testMap.put("data", T);
		return JSON.toJSONString(testMap);
	}
}
