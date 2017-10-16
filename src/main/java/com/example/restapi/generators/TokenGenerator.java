package com.example.restapi.generators;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class TokenGenerator {

	public static String getToken(Integer length) {
		Integer defaultLength = 20;
		length = length != null ? length : defaultLength;
		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_!-".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}

}
