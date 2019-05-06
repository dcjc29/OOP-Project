package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class security {
	private String algorithm="MD5";
	
	public String generateHash(String input, byte[] salt) {
		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);
			digest.reset();
			digest.update(salt);
			byte[] hash =digest.digest(input.getBytes());
			return bytesToStringHex(hash);
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	private String bytesToStringHex(byte[] hash) {
		final char[] hexArray = "0123456789ABCDEF".toCharArray() ;
		char[] hexChars = new char[hash.length*2];
		for(int i = 0; i<hash.length;i++) {
			int j = hash[i] & 0xFF;
			
			hexChars[i*2] = hexArray[j >>> 4];
			hexChars[i*2 + 1] =hexArray[j & 0x0F];
		}
		return new String(hexChars);
	}

	public byte[] createSalt() {
		byte[] bytes = new byte[20];
		SecureRandom random = new SecureRandom();
		random.nextBytes(bytes);
		
		return bytes;
	}
}
