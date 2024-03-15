package es.us.lsi.dad;

import java.util.Objects;

public class LDR {
	
	private Integer placaId;
	private Integer sensorId;
	private Double ohmios;
	private Long timeStamp;

	
	public LDR(Integer placaId, Integer sensorId, Double ohmios, Long timeStamp) {
		
		super();
		this.placaId = placaId;
		this.sensorId = sensorId;
		this.ohmios = ohmios;
		this.timeStamp = timeStamp;
		
	}
	
	public Integer getPlacaId() {
		return placaId;
	}
	
	public Integer getSensorId() {
		return sensorId;
	}
	public void setSensorId(Integer sensorId) {
		this.sensorId = sensorId;
	}
	public Double getOhmios() {
		return ohmios;
	}
	public void setOhmios(Double ohmios) {
		this.ohmios = ohmios;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sensorId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LDR other = (LDR) obj;
		return Objects.equals(sensorId, other.sensorId);
	}

	@Override
	public String toString() {
		return "LDR [placaId=" + placaId + ", sensorId=" + sensorId + ", ohmios=" + ohmios + ", timeStamp=" + timeStamp
				+ "]";
	}
	
	
}
