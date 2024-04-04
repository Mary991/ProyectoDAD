package es.us.lsi.dad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class SensorEntityListWrapper {
	private List<SensorEntity> placasList;
	
	
	public SensorEntityListWrapper() {
		super();
	}

	public SensorEntityListWrapper(Collection<SensorEntity> userList) {
		super();
		this.placasList = new ArrayList<SensorEntity>(placasList);
	}
	
	public SensorEntityListWrapper(List<SensorEntity> placasList) {
		super();
		this.placasList = new ArrayList<SensorEntity>(placasList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(placasList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SensorEntityListWrapper other = (SensorEntityListWrapper) obj;
		return Objects.equals(placasList, other.placasList);
	}

	@Override
	public String toString() {
		return "SensorEntityListWrapper [placasList=" + placasList + "]";
	}
	
	

}
