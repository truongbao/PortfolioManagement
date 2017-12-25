package utility;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class ConvertHTML {
	     //lay ra cac phan tu cah nhau bởi \n
         //sau đó nối lại và cho chúng cách nhau bởi </br>
		 public String nl_br(String str){
			String replaceString=str.replace("\n","</br>");
		    return replaceString;
	     }
	 
}
