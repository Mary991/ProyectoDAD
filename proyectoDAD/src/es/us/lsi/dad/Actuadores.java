package es.us.lsi.dad;

import java.util.Objects;

public class Actuadores {
	public class Rele {
		Integer placaId;
		Integer sensorId;
		Long timeStamp;
		Boolean activo;
		
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

		public Integer getSensorId() {
			return sensorId;
		}

		public Long getTimeStamp() {
			return timeStamp;
		}

		public Boolean getActivo() {
			return activo;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(placaId, sensorId);
			return result;
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
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return Objects.equals(placaId, other.placaId) && Objects.equals(sensorId, other.sensorId);
		}

		private Actuadores getEnclosingInstance() {
			return Actuadores.this;
		}

		@Override
		public String toString() {
			return "Rele [placaId=" + placaId + ", sensorId=" + sensorId + ", timeStamp=" + timeStamp + ", activo="
					+ activo + "]";
		}
		
		
	}
}
