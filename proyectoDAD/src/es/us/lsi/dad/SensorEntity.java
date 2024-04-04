package es.us.lsi.dad;

import java.util.Objects;

public class SensorEntity {		
	private LDR ldr;
    private LED led;
    private UltraSonido ultraSonido;
    
	public SensorEntity(LDR ldr, LED led, UltraSonido ultraSonido) {
		super();
		this.ldr = ldr;
		this.led = led;
		this.ultraSonido = ultraSonido;
	}

	public LDR getLdr() {
		return ldr;
	}

	public void setLdr(LDR ldr) {
		this.ldr = ldr;
	}

	public LED getLed() {
		return led;
	}

	public void setLed(LED led) {
		this.led = led;
	}

	public UltraSonido getUltraSonido() {
		return ultraSonido;
	}

	public void setUltraSonido(UltraSonido ultraSonido) {
		this.ultraSonido = ultraSonido;
	}
	
	

	@Override
	public String toString() {
		return "SensorEntity [ldr=" + ldr + ", led=" + led + ", ultraSonido=" + ultraSonido + "]";
	}



	public static class LDR {
		Integer placaId;
		Integer sensorId;
		Double ohmios;
		Long TimeStamps;
		
		public LDR(Integer placaId, Integer sensorId, Double ohmios, Long timeStamps) {
			super();
			this.placaId = placaId;
			this.sensorId = sensorId;
			this.ohmios = ohmios;
			TimeStamps = timeStamps;
		}

		public Integer getPlacaId() {
			return placaId;
		}

		public Integer getSensorId() {
			return sensorId;
		}

		public Double getOhmios() {
			return ohmios;
		}

		public Long getTimeStamps() {
			return TimeStamps;
		}

		
		public void setPlacaId(Integer placaId) {
			this.placaId = placaId;
		}

		public void setSensorId(Integer sensorId) {
			this.sensorId = sensorId;
		}

		public void setOhmios(Double ohmios) {
			this.ohmios = ohmios;
		}

		public void setTimeStamps(Long timeStamps) {
			TimeStamps = timeStamps;
		}

		@Override
		public int hashCode() {
			return Objects.hash(placaId, sensorId);
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
			return Objects.equals(placaId, other.placaId) && Objects.equals(sensorId, other.sensorId);
		}

		@Override
		public String toString() {
			return "LDR [placaId=" + placaId + ", sensorId=" + sensorId + ", ohmios=" + ohmios + ", TimeStamps="
					+ TimeStamps + "]";
		}	
	}

	public static class LED {
		Integer placaId;
		Integer sensorId;
		Integer luminosidad;
		Long timeStamp;
		
		public LED(Integer placaId, Integer sensorId, Integer luminosidad, Long timeStamp) {
			super();
			this.placaId = placaId;
			this.sensorId = sensorId;
			this.luminosidad = luminosidad;
			this.timeStamp = timeStamp;
		}
		
		public Integer getPlacaId() {
			return placaId;
		}
		public Integer getSensorId() {
			return sensorId;
		}
		public Integer getLuminosidad() {
			return luminosidad;
		}
		public Long getTimeStamp() {
			return timeStamp;
		}

		

		public void setPlacaId(Integer placaId) {
			this.placaId = placaId;
		}

		public void setSensorId(Integer sensorId) {
			this.sensorId = sensorId;
		}

		public void setLuminosidad(Integer luminosidad) {
			this.luminosidad = luminosidad;
		}

		public void setTimeStamp(Long timeStamp) {
			this.timeStamp = timeStamp;
		}

		@Override
		public int hashCode() {
			return Objects.hash(placaId, sensorId);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LED other = (LED) obj;
			return Objects.equals(placaId, other.placaId) && Objects.equals(sensorId, other.sensorId);
		}

		@Override
		public String toString() {
			return "LED [placaId=" + placaId + ", sensorId=" + sensorId + ", luminosidad=" + luminosidad
					+ ", timeStamp=" + timeStamp + "]";
		}

	}
//	public static record UltraSonido(Integer placaId,Integer sensorId,Integer distancia) {
//
//	}
	
	public static class UltraSonido {
		Integer placaId;
		Integer sensorId;
		Integer distancia;
		
		public UltraSonido(Integer placaId, Integer sensorId, Integer distancia) {
			super();
			this.placaId = placaId;
			this.sensorId = sensorId;
			this.distancia = distancia;
		}

		public Integer getPlacaId() {
			return placaId;
		}

		public Integer getSensorId() {
			return sensorId;
		}

		public Integer getDistancia() {
			return distancia;
		}

		

		public void setPlacaId(Integer placaId) {
			this.placaId = placaId;
		}

		public void setSensorId(Integer sensorId) {
			this.sensorId = sensorId;
		}

		public void setDistancia(Integer distancia) {
			this.distancia = distancia;
		}

		@Override
		public int hashCode() {
			return Objects.hash(placaId, sensorId);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			UltraSonido other = (UltraSonido) obj;
			return Objects.equals(placaId, other.placaId) && Objects.equals(sensorId, other.sensorId);
		}

		@Override
		public String toString() {
			return "UltraSonido [placaId=" + placaId + ", sensorId=" + sensorId + ", distancia=" + distancia + "]";
		}	
	}
}
