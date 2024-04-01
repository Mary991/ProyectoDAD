package es.us.lsi.dad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SensorEntityListWrapper {
	private List<Sensor> placasList;
	public SensorEntityListWrapper() {
		super();
	}

	public SensorEntityListWrapper(Collection<Sensor> userList) {
		super();
		this.placasList = new ArrayList<Sensor>(placasList);
	}
	
	public SensorEntityListWrapper(List<Sensor> placasList) {
		super();
		this.placasList = new ArrayList<Sensor>(placasList);
	}
	
	

}
