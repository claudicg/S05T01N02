package cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.utils;

public class Validations {
	
	public static boolean isValidName(String name) {
		return name.matches("^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+$");
	}
	
	public static boolean isValidNumber(String id) {
		return id.matches("^[1-9]{1}[0-9]*$");
	}
	
}
