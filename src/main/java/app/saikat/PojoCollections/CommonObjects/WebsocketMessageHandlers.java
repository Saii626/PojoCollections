package app.saikat.PojoCollections.CommonObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class WebsocketMessageHandlers {

	protected Map<Class<?>, List<Tuple<Class<?>, String>>> handlers = new HashMap<>();

	public Map<Class<?>, List<Tuple<Class<?>, String>>> getHandlers() {
		return handlers;
	}
}