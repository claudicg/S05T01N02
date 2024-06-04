package cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.enums;

public enum CountryTypeEnum {

	EU("EU"),
	NON_EU("NON-EU");
	
	private String type;

	private CountryTypeEnum(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}	
}
