package cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.dto;

public class FlowerDTO {

	private Integer flowerId;
	private String flowerName;
	private String flowerCountry;
	private String flowerType;
	
	public FlowerDTO() {
		super();
	}

	public FlowerDTO(String flowerName, String flowerCountry, String flowerType) {
		super();
		this.flowerName = flowerName;
		this.flowerCountry = flowerCountry;
		this.flowerType = flowerType;
	}

	public Integer getFlowerId() {
		return flowerId;
	}

	public void setFlowerId(Integer flowerId) {
		this.flowerId = flowerId;
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

	public String getFlowerType() {
		return flowerType;
	}

	public void setFlowerType(String flowerType) {
		this.flowerType = flowerType;
	}

	@Override
	public String toString() {
		return "FlowerDTO [flowerId=" + flowerId + ", flowerName=" + flowerName + ", flowerCountry=" + flowerCountry
				+ ", flowerType=" + flowerType + "]";
	}
	
	
}
