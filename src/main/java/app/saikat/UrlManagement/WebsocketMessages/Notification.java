package app.saikat.UrlManagement.WebsocketMessages;

import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

public class Notification {

    @SerializedName("id")
    private UUID id;

    @SerializedName("timestamp")
    private Date timestamp;

    @SerializedName("source")
    private String source;

    @SerializedName("title")
    private String title;

    @SerializedName("message")
    private String message;

    @Override
    public String toString() {
        return "\nid:\t" + id.toString() +
                "\ntimestamp:\t" + DateFormat.getDateTimeInstance().format(timestamp) +
                "\nsource:\t" + source +
                "\ntitle:\t" + title +
                "\nmessage:\t" + message;

    }

    public UUID getId() {
        return id;
    }

   public String getMessage() {
       return message;
   }
   
   public String getSource() {
       return source;
   }
   
   public Date getTimestamp() {
       return timestamp;
   }
  
   public String getTitle() {
       return title;
   }
}
