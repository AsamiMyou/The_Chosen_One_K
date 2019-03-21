package com.theChosenOne.Util;

import java.util.UUID;
/**
 * 
 * @author Asami Myou
 *
 */
public class IdUtils {
	
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
