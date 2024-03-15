package es.us.lsi.dad;

import java.util.Objects;

public class Rele {
	
	private Integer placaId; 
	private Integer sensorId;
	private Long timeStamp;
	private Boolean activo;
	
	public Rele(Integer placaId, Integer sensorId, Long timeStamp, Boolean activo) {
		super();
		this.placaId = placaId;
		this.sensorId = sensorId;
		this.timeStamp = timeStamp;
		this.activo = activo;
	}
	
	public Integer getPlacaId() {
		return placaId;
	}
	public void setPlacaId(Integer placaId) {
		this.placaId = placaId;
	}
	public Integer getSensorId() {
		return sensorId;
	}
	public void setSensorId(Integer sensorId) {
		this.sensorId = sensorId;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
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
		Rele other = (Rele) obj;
		return Objects.equals(sensorId, other.sensorId);
	}

	@Override
	public String toString() {
		return "Rele [placaId=" + placaId + ", sensorId=" + sensorId + ", timeStamp=" + timeStamp + ", activo=" + activo
				+ "]";
	}

	
	
	
	
	
	
	
}
