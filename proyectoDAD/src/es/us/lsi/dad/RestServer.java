package es.us.lsi.dad;




import java.util.HashMap;
import java.util.Map;

import java.util.stream.Collectors;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;


public class RestServer extends AbstractVerticle{
	private Map<Integer, SensorEntity> placas = new HashMap<Integer, SensorEntity>();
	private Gson gson;

	public void start(Promise<Void> startFuture) {
		// Creating some synthetic data


		// Instantiating a Gson serialize object using specific date format
		gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

		// Defining the router object
		Router router = Router.router(vertx);

		// Handling any server startup result
		vertx.createHttpServer().requestHandler(router::handle).listen(8080, result -> {
			if (result.succeeded()) {
				startFuture.complete();
			} else {
				startFuture.fail(result.cause());
			}
		});

		// Defining URI paths for each method in RESTful interface, including body
		// handling by /api/users* or /api/users/*
		//Hago otro get
		router.route("/api/placas*").handler(BodyHandler.create());
		//Preguntamos por todas las placas
		router.get("/api/placas").handler(this::getAllWithParams);
		//Preguntamos por una placa en concreto
		router.get("/api/placas/:placaId").handler(this::getOnePlaca);
		router.get("/api/placas/sensores").handler(this::getAllWithParamsSensor);
		router.get("/api/placas/:placaId/:sensorId").handler(this::getOnePlacaSensor);
//		router.post("/api/placas").handler(this::addOne);
		router.delete("/api/placas/:placaId").handler(this::deleteOne);
		router.put("/api/placas/:placaId").handler(this::putOne);
	}
	@SuppressWarnings("unused")
	private void getAll(RoutingContext routingContext) {
		routingContext.response().putHeader("content-type", "application/json; charset=utf-8").setStatusCode(200)
		.end(gson.toJson(new SensorEntityListWrapper(placas.values())));
	}

	private void getAllWithParamsSensor(RoutingContext routingContext) {
		final Integer placaId = routingContext.queryParams().contains("placaId") ? Integer.parseInt(routingContext.queryParam("placaId").get(0)) : null;
		final Integer id = routingContext.queryParams().contains("sensorId") ? Integer.parseInt(routingContext.queryParam("id").get(0)) : null;
		
		routingContext.response().putHeader("content-type", "application/json; charset=utf-8").setStatusCode(200)
		.end(gson.toJson(new SensorEntityListWrapper(placas.values().stream().filter(elem -> {
			boolean res = true;
			res = res && id != null ? elem.getLdr().getPlacaId().equals(placaId) : true;
			res = res && id != null ? elem.getLed().getPlacaId().equals(placaId) : true;
			res = res && id != null ? elem.getUltraSonido().getPlacaId().equals(placaId) : true;
			res = res && id != null ? elem.getLdr().getSensorId().equals(id) : true;
			res = res && id != null ? elem.getLed().getSensorId().equals(id) : true;
			res = res && id != null ? elem.getUltraSonido().getSensorId().equals(id) : true;
			return res;
		}).collect(Collectors.toSet()))));
		
	}
	
	private void getAllWithParams(RoutingContext routingContext) {
		//He cambiado el operador ternario por el parseInt
		final Integer id = routingContext.queryParams().contains("placaId") ? Integer.parseInt(routingContext.queryParam("placaId").get(0)) : null;
		//Ponemos todas las placas que estén en uso, preguntando por cada sensor qué placa tiene conectada,y pasandolo a un set
		routingContext.response().putHeader("content-type", "application/json; charset=utf-8").setStatusCode(200)
		.end(gson.toJson(new SensorEntityListWrapper(placas.values().stream().filter(elem -> {
			boolean res = true;
			res = res && id != null ? elem.getLdr().getPlacaId().equals(id) : true;
			res = res && id != null ? elem.getLed().getPlacaId().equals(id) : true;
			res = res && id != null ? elem.getUltraSonido().getPlacaId().equals(id) : true;
			return res;
		}).collect(Collectors.toSet()))));
	}

	private void getOnePlaca(RoutingContext routingContext) {
		int id = Integer.parseInt(routingContext.request().getParam("placaId"));
		if (placas.containsKey(id)) {
			SensorEntity se = placas.get(id);
			routingContext.response().putHeader("content-type", "application/json; charset=utf-8").setStatusCode(200)
			.end(gson.toJson(se));
		} else {
			routingContext.response().putHeader("content-type", "application/json; charset=utf-8").setStatusCode(204)
			.end();
		}
	}
	
	private void getOnePlacaSensor(RoutingContext routingContext) {
		//COMPROBAR 
		int id = Integer.parseInt(routingContext.request().getParam("placaId"));
		int sensorid = Integer.parseInt(routingContext.request().getParam("sensorId"));  
		if (placas.containsKey(id)) {
			SensorEntity se = placas.get(sensorid);
			routingContext.response().putHeader("content-type", "application/json; charset=utf-8").setStatusCode(200)
			.end(gson.toJson(se));
		} else {
			routingContext.response().putHeader("content-type", "application/json; charset=utf-8").setStatusCode(204)
			.end();
		}
	}

//	private void addOne(RoutingContext routingContext) {
//		final SensorEntity sensor = gson.fromJson(routingContext.getBodyAsString(), SensorEntity.class);
//		placas.put(sensor., user);
//		routingContext.response().setStatusCode(201).putHeader("content-type", "application/json; charset=utf-8")
//		.end(gson.toJson(user));
//	}

	private void deleteOne(RoutingContext routingContext) {
		int id = Integer.parseInt(routingContext.request().getParam("userid"));
		if (placas.containsKey(id)) {
			SensorEntity user = placas.get(id);
			placas.remove(id);
			routingContext.response().setStatusCode(200).putHeader("content-type", "application/json; charset=utf-8")
			.end(gson.toJson(user));
		} else {
			routingContext.response().setStatusCode(204).putHeader("content-type", "application/json; charset=utf-8")
			.end();
		}
	}

	private void putOne(RoutingContext routingContext) {
		//Preguntar Marina: Al poner un id en la p
		int id = Integer.parseInt(routingContext.request().getParam("userid"));
		SensorEntity se = placas.get(id);
		final SensorEntity element = gson.fromJson(routingContext.getBodyAsString(), SensorEntity.class);
//		ds.setName(element.getName());
		se.getLdr().setPlacaId(element.getLdr().getPlacaId());
//		se.getLed(element.getSurname());
//		se.setBirthdate(element.getBirthdate());
//		se.setPassword(element.getPassword());
//		ds.setUsername(element.getUsername());
		placas.put(se.getLdr().getPlacaId(), se);
		routingContext.response().setStatusCode(201).putHeader("content-type", "application/json; charset=utf-8")
		.end(gson.toJson(element));
	}

//	private void createSomeData(int number) {
//		Random rnd = new Random();
//		IntStream.range(0, number).forEach(elem -> {
//			int id = rnd.nextInt();
//			users.put(id, new UserEntity(id, "Nombre_" + id, "Apellido_" + id,
//					new Date(Calendar.getInstance().getTimeInMillis() + id), "Username_" + id, "Password_" + id));
//		});
//	}


}
