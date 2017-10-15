package com.example.restapi.generators;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class TokenGenerator {
	private Integer length;

	public String getToken(Integer length) {
		Integer defaultLength = 20;
		length = length != null ? length : defaultLength;
		this.length = length;
		char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < this.length; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}

}
