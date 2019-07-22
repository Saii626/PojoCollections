package app.saikat.UrlManagement.WebsocketMessages.ServerMessages;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.UUID;

public class Notification {

    @SerializedName("id")
    private UUID id = UUID.randomUUID();

    @SerializedName("timestamp")
    private Date timestamp;

    @SerializedName("title")
    private String title;

    @SerializedName("message")
    private String message;

    @SerializedName("source")
    private String source;


    public Notification(UUID id, Date timestamp, String title, String message, String source) {
        this.id = id;
        this.timestamp = timestamp;
        this.title = title;
        this.message = message;
        this.source = source;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }
   
    public String getSource() {
        return source;
    }
}
