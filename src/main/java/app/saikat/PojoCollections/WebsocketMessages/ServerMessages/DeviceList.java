package app.saikat.PojoCollections.WebsocketMessages.ServerMessages;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import app.saikat.PojoCollections.ResponseObjects.CreatedDevice;

public class DeviceList {

    @SerializedName("device_list")
    private List<CreatedDevice> devices;


    public DeviceList(List<CreatedDevice> devices) {
        this.devices = devices;
    }

    public List<CreatedDevice> getDevices() {
        return this.devices;
    }

}