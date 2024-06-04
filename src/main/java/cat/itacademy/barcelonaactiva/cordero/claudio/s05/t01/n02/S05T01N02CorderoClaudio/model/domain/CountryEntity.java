package cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="countries", schema="flowers")
public class CountryEntity {
	

	@Id
	@Column(name = "country_name")
	private String countryName;
	
	@Column(name = "country_type")
	private String countryType;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryType() {
		return countryType;
	}

	public void setCountryType(String countryType) {
		this.countryType = countryType;
	}

	@Override
	public String toString() {
		return "CountryEntity [countryName=" + countryName + ", countryType=" + countryType + "]";
	}
}
