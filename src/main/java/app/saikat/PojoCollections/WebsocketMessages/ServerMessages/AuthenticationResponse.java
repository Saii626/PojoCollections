package app.saikat.PojoCollections.WebsocketMessages.ServerMessages;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

import app.saikat.PojoCollections.CommonObjects.Status;

public class AuthenticationResponse {

    @SerializedName("status")
    private Status status;

    @SerializedName("options")
    private Map<String, String> options;

    public AuthenticationResponse(Status status, Map<String, String> options) {
        this.status = status;
        this.options = options;
    }

    public Status getStatus() {
        return status;
    }

    public Map<String, String> getOptions() {
        return options;
    }
}