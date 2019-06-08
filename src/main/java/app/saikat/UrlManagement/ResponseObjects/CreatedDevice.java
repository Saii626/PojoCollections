package app.saikat.UrlManagement.ResponseObjects;

import java.util.UUID;

public class CreatedDevice {

    private UUID id;
    private String name;

    public CreatedDevice(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}