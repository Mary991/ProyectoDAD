package es.us.lsi.dad;

public class Actuadores {
	public static record Rele(Integer placaId,Integer sensorId,Long timeStamp,Boolean activo) {

	}
}
