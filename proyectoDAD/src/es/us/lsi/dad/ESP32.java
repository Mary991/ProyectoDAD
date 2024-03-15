package es.us.lsi.dad;

import java.util.Objects;

public class ESP32 {
	
	private Integer placaId;

	public Integer getPlacaId() {
		return placaId;
	}

	public void setPlacaId(Integer placaId) {
		this.placaId = placaId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(placaId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ESP32 other = (ESP32) obj;
		return Objects.equals(placaId, other.placaId);
	}

	@Override
	public String toString() {
		return "ESP32 [placaId=" + placaId + "]";
	}
	
	
	
	
	
	

}
