package app.saikat.UrlManagement.CommonObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class WebsocketMessageHandlers {

    public static class Tuple<X, Y> {
        public X first;

        public Y second;

        public Tuple(X first, Y second) {
            this.first = first;
            this.second = second;
        }
    }

    protected Map<Class<?>, List<Tuple<Class<?>, String>>> handlers = new HashMap<>();

    public Map<Class<?>, List<Tuple<Class<?>, String>>> getHandlers() {
        return handlers;
    }
}