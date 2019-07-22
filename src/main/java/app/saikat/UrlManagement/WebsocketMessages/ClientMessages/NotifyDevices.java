package app.saikat.UrlManagement.WebsocketMessages.ClientMessages;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

import app.saikat.UrlManagement.CommonObjects.Tuple;
import app.saikat.UrlManagement.WebsocketMessages.ServerMessages.Notification;

public class NotifyDevices {

    @SerializedName("source")
    private String source;

    @SerializedName("notification_map")
    private Map<String, Tuple<Notification, Integer>> notificationMap;

    public NotifyDevices(String source) {
        this(source, new HashMap<>());
    }

    public NotifyDevices(String source, Map<String, Tuple<Notification, Integer>>  notificationMap) {
        this.source = source;
        this.notificationMap = notificationMap;
    }

    public void add(String device, Notification notification, int ttl) {
        this.notificationMap.put(device, new Tuple<>(notification, ttl));
    }

    public String getSource() {
        return this.source;
    }

    public Map<String, Tuple<Notification, Integer>> getNotificationMap() {
        return this.notificationMap;
    }

}