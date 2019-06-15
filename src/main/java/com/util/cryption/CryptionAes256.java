package com.util.cryption;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidAlgorithmParameterException;
import org.apache.commons.codec.binary.Base64;
 
public class CryptionAes256 {
 
 private static volatile CryptionAes256 INSTANCE;
 
 final static String secretKey   = "12345678901234567890123456789012"; //32bit
 static String IV                = "3e4r5tred32w809m"; //16bit
 
 public static CryptionAes256 getInstance(){
     if(INSTANCE==null){
         synchronized(CryptionAes256.class){
             if(INSTANCE==null)
                 INSTANCE=new CryptionAes256();
         }
     }
     return INSTANCE;
 }
 
 private CryptionAes256(){
     IV = secretKey.substring(0,16);
    }
 
 //암호화
 public static String AES_Encode(String str) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
     byte[] keyData = secretKey.getBytes();
 
 SecretKey secureKey = new SecretKeySpec(keyData, "AES");
 
 Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
 c.init(Cipher.ENCRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes()));
 
 byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
 String enStr = new String(Base64.encodeBase64(encrypted));
 
 return enStr;
 }
 
 //복호화
 public static String AES_Decode(String str) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
  byte[] keyData = secretKey.getBytes();
  SecretKey secureKey = new SecretKeySpec(keyData, "AES");
  Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
  c.init(Cipher.DECRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes("UTF-8")));
 
  byte[] byteStr = Base64.decodeBase64(str.getBytes());
 
  return new String(c.doFinal(byteStr),"UTF-8");
 }
 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String aes = AES_Encode("1111");
		System.out.println("Aes256 encrypt : " + aes);
		aes = AES_Decode(aes);
		System.out.println("Aes256 decrypt : " + aes);
	}
}