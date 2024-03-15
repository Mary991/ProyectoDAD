package es.us.lsi.dad;

import java.util.Objects;

public class Ultrasonido {
	
	private Integer placaId;
	private Integer sensorId;
	private Integer distancia;
	
	public Ultrasonido(Integer placaId, Integer sensorId, Integer distancia) {
		super();
		this.placaId = placaId;
		this.sensorId = sensorId;
		this.distancia = distancia;
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

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
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
		Ultrasonido other = (Ultrasonido) obj;
		return Objects.equals(sensorId, other.sensorId);
	}

	@Override
	public String toString() {
		return "Ultrasonido [placaId=" + placaId + ", sensorId=" + sensorId + ", distancia=" + distancia + "]";
	}
	
	
}
