package es.us.lsi.dad;

import java.util.Objects;

public class SensorLuz {
	
	private Integer placaId;
	private Integer sensorId;
	private Integer luminosidad; // value
	private Long timeStamp;
	//Status (?
	
	
	
	public Integer getSensorId() {
		
		return sensorId;
	}

	
	public SensorLuz(Integer sensorId, Integer luminosidad) {
		super();
		this.sensorId = sensorId;
		this.luminosidad = luminosidad;
	}


	public void setSensorId(Integer sensorId) {
		this.sensorId = sensorId;
	}
	public Integer getLuminosidad() {
		return luminosidad;
	}
	public void setLuminosidad(Integer luminosidad) {
		this.luminosidad = luminosidad;
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
		SensorLuz other = (SensorLuz) obj;
		return Objects.equals(sensorId, other.sensorId);
	}


	@Override
	public String toString() {
		return "SensorLuz [sensorId=" + sensorId + ", luminosidad=" + luminosidad + "]";
	}


	public Integer getPlacaId() {
		return placaId;
	}


	public void setPlacaId(Integer placaId) {
		this.placaId = placaId;
	}
	
	
	
	
	
	

}
