package cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.security;

import org.jasypt.util.text.BasicTextEncryptor;

public class JasyptService {

	
	public String getUnencryptedValue(String property) {

		BasicTextEncryptor decryptor = new BasicTextEncryptor();
		decryptor.setPassword(System.getProperty("jasypt.encryptor.password"));  		
		return decryptor.decrypt(property);
	}
}
