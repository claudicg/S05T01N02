package cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="flowers", schema="flowers")
public class FlowerEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "flower_id")
	private Integer flowerId;
	
	@Column(name = "flower_name")
	private String flowerName;
	
	@Column(name = "flower_country")
	private String flowerCountry;

	public FlowerEntity() {
		super();
	}

	public FlowerEntity(Integer flowerId, String flowerName, String flowerCountry) {
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
		return "FlowerEntity [flowerId=" + flowerId + ", flowerName=" + flowerName + ", flowerCountry=" + flowerCountry
				+ "]";
	}
}
