package app.saikat.UrlManagement.WebsocketMessages.ClientMessages;

import java.util.UUID;

import com.google.gson.annotations.SerializedName;

public class Authentication {

    @SerializedName("id")
    private UUID id;

    @SerializedName("token")
    private String token;

    public Authentication(UUID id, String token) {
        this.id = id;
        this.token = token;
    }

    public UUID getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}