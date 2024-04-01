package es.us.lsi.dad;

public class Sensor {	
	public static record LDR(Integer placaId,Integer sensorId, Double ohmios,Long TimeStamps) {
		
	}
	
	//luminosidad: Regulamos la luz en funcion del LDR
	public static record LED(Integer placaId,Integer sensorId,Integer luminosidad,Long timeStamp) {
		
	}
	public static record UltraSonido(Integer placaId,Integer sensorId,Integer distancia) {
		
	}
}
