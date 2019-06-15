package com.util.cryption;
import java.security.MessageDigest;

public class CryptionSha256 {
	public static String encrypt(String planText) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(planText.getBytes());
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				String hex = Integer.toHexString(0xff & byteData[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sha = encrypt("isak123!");
		String sha1 = encrypt("jjw1!");
		System.out.println("sha256 encrypt : " + sha);
		System.out.println("sha256 length : " + sha.length());
		System.out.println("sha256 encrypt : " + sha1);
		System.out.println("sha256 length : " + sha1.length());
	}
}
