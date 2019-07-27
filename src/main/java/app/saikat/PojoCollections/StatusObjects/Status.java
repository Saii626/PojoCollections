package app.saikat.PojoCollections.StatusObjects;

import java.util.ArrayList;
import java.util.List;

public class Status {

    private static Status instance;

    static {
        instance = new Status();
    }

    private List<StatusAware> statusAwares;

    private Status() {
        statusAwares = new ArrayList<>();
    }

    public static void registerStatusAware(StatusAware statusAware) {
        instance.statusAwares.add(statusAware);
    }

}