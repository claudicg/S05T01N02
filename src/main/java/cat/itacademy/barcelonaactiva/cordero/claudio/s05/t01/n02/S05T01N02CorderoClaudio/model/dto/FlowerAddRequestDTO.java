package cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.dto;

public class FlowerAddRequestDTO {
	
	private String flowerName;
	private String flowerCountry;
	
	
	public FlowerAddRequestDTO(String flowerName, String flowerCountry) {
		super();
		this.flowerName = flowerName;
		this.flowerCountry = flowerCountry;
	}


	public String getFlowerName() {
		return flowerName;
	}

	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}

	public String getFlowerCountry() {
		return flowerCountry;
	}
	public void setFlowerCountry(String flowerCountry) {
		this.flowerCountry = flowerCountry;
	}


	@Override
	public String toString() {
		return "FlowerAddRequestDTO [flowerName=" + flowerName + ", flowerCountry=" + flowerCountry + "]";
	}
	
}
