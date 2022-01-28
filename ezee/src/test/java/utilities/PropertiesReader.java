package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {
	
	static FileInputStream oFile;
	public static String getPropertyValue(String sFileName,String sKey) {
		String sFile = "./data"+sFileName+ ".properties";
		String sValue=null;
		try {
			oFile = new FileInputStream(sFile);
			Properties oProp = new Properties();
			sValue = oProp.getProperty(sKey);
			return sValue;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sValue;
	}

}
