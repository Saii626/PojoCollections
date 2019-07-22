package app.saikat.UrlManagement.WebsocketMessages.ClientMessages;

public class GetDeviceList {

    private String name;

    public GetDeviceList() {
        this.name = "random";
    }

    public String getName() {
        return name;
    }
    
}