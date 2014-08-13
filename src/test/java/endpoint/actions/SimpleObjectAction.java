package endpoint.actions;

import java.util.Map;

import endpoint.HttpException;
import endpoint.SimpleObject;
import endpoint.Target;
import endpoint.response.JsonResponse;
import endpoint.utils.JsonUtils;

@Target(SimpleObject.class)
public class SimpleObjectAction extends Action {

	@PUT("active")
	public JsonResponse activate(Long id) {
		SimpleObject object = r.query(SimpleObject.class).id(id);
		object.setAString("i was changed in action");
		r.save(object);
		return new JsonResponse(JsonUtils.to(object));
	}

	@PUT("params_action")
	public JsonResponse paramsAction(Long id, Map<String, String> params) {
		return new JsonResponse(params.get("x"));
	}

	@GET("me")
	public JsonResponse me() {
		return new JsonResponse("xpto");
	}

}
