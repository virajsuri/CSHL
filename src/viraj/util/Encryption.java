package viraj.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {
	static String IV = "AAAAAAAAAAAAAAAA";

	
	public static byte[] encryptString(String plaintext, String encryptionKey) {
		if(encryptionKey.length() != 16) {
			System.err.println("Invalid AES key length: "+encryptionKey.length() + " - must be 16 bytes");
			return null;
		}
		plaintext+="\0\0\0"; //null paddding
		byte []cipher=null;
		try {
			cipher = encrypt(plaintext, encryptionKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return cipher;
	}
	
	public static String decryptString(byte[] cipher, String encryptionKey) {
		if(encryptionKey.length() != 16) {
			System.err.println("Invalid AES key length: "+encryptionKey.length() + " - must be 16 bytes");
			return null;
		}
		
	    String decrypted="";
		try {
			decrypted = decrypt(cipher, encryptionKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return decrypted;
	}
	
	
	
	public static byte[] encrypt(String plainText, String encryptionKey) throws Exception {
	    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
	    SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
	    cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
	    return cipher.doFinal(plainText.getBytes("UTF-8"));
	  }
	
	public static String decrypt(byte[] cipherText, String encryptionKey) throws Exception{
	    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
	    SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
	    cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
	    return new String(cipher.doFinal(cipherText),"UTF-8");
	  }
}
