package app.saikat.UrlManagement;

public enum SocketBaseUrl {

    REMOTE("wss://saikat.app"),
    LOCAL("ws://192.168.100.2"),
    SELF("ws://127.0.0.1");

    private String baseUrl;

    SocketBaseUrl(String str) {
        baseUrl = str;
    }

    public String getUrl() {
        return baseUrl;
    }
}
