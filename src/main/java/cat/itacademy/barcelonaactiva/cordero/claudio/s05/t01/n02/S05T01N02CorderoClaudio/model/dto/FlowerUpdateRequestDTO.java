package cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.dto;

public class FlowerUpdateRequestDTO {

	private Integer flowerId;
	private String flowerName;
	private String flowerCountry;
	
	
	public FlowerUpdateRequestDTO(Integer flowerId, String flowerName, String flowerCountry) {
		super();
		this.flowerId = flowerId;
		this.flowerName = flowerName;
		this.flowerCountry = flowerCountry;
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


	@Override
	public String toString() {
		return "FlowerUpdateRequestDTO [flowerId=" + flowerId + ", flowerName=" + flowerName + ", flowerCountry="
				+ flowerCountry + "]";
	}
}
