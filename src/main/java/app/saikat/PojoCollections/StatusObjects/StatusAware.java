package app.saikat.PojoCollections.StatusObjects;

import java.util.Map;

public interface StatusAware {

    /**
     * Returns a brief status of a component
     * @return brief status message
     */
    String getStatus();

    /**
     * Returns a detailed status map of a type
     * @param type type of status requested
     * @return a status map of given type
     */
    default Map<String, String> getDetailedStatus(String type) {
        return null;
    }
}