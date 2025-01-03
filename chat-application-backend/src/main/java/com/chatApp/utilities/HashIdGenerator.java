package com.chatApp.utilities;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class HashIdGenerator {
	
	public String generatedHashId(String input) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
			
			// convert the base64 to make it shorter
			String base64Hash = Base64.getUrlEncoder().withoutPadding().encodeToString(hashBytes);
			
			// truncate to make the characters shorter
			return base64Hash.substring(0, 8);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error generating hash ID", e);
		}
	}

}
