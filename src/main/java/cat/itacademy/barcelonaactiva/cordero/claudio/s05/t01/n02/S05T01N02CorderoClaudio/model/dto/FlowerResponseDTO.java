package cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.dto;

public class FlowerResponseDTO {

	private FlowerDTO flower;
	private String message;
	private String error;
	
	public FlowerResponseDTO() {
		super();
		this.flower = new FlowerDTO();
		this.message = "";
		this.error = "";
	}
	
	public FlowerResponseDTO(FlowerDTO flower, String message, String error) {
		super();
		this.flower = flower;
		this.message = message;
		this.error = error;
	}

	public FlowerDTO getFlower() {
		return flower;
	}

	public void setFlower(FlowerDTO flower) {
		this.flower = flower;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "FlowerResponseDTO [flower=" + flower + ", message=" + message + ", error=" + error + "]";
	}	
}
