package com.jsp.util;

import java.util.UUID;

public class MakeFileName {

	public static String toUUIDFileName(String filename, String delimiter) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid + delimiter + filename;
	}
}
